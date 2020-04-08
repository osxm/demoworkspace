import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3' #不显示AVX，CUDA等警告, 没有GPU的机器可以加上

#1. 导入TensorFlow
import tensorflow as tf

mnist = tf.keras.datasets.mnist #2. 通过keras使用数据集
(x_train, y_train), (x_test, y_test) = mnist.load_data() # 载入数据
x_train, x_test = x_train / 255.0, x_test / 255.0  # 3. 数据归一化， 范围0到1之间，因为像素值的范围是0~255

# 4. 搭建模型，选择优化器和损失函数
model = tf.keras.models.Sequential([
  tf.keras.layers.Flatten(input_shape=(28, 28)),
  tf.keras.layers.Dense(128, activation='relu'),
  tf.keras.layers.Dropout(0.2),
  tf.keras.layers.Dense(10, activation='softmax')
])
#5. 模型编译
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])
 #6. 训练并验证模型（使用训练集数据）
model.fit(x_train, y_train, epochs=10)
#7. 评估模型（使用测试集数据）
model.evaluate(x_test,  y_test, verbose=2)