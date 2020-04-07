import os 
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3' # 不显示AVX， CUDA等警告

# https://tensorflow.google.cn/tutorials/keras/classification?hl=zh_cn
# 安装 TensorFlow
import tensorflow as tf
from tensorflow import keras

# 帮助库
import numpy as np # 数学运算
import matplotlib.pyplot as plt # 可视化库

class_names = ['T-shirt/top', 'Trouser', 'Pullover', 'Dress', 'Coat',
               'Sandal', 'Shirt', 'Sneaker', 'Bag', 'Ankle boot']
# 导入数据
fashion_mnist = keras.datasets.fashion_mnist
(train_images, train_labels), (test_images, test_labels) = fashion_mnist.load_data()

print(train_images.shape) # (60000, 28, 28), 6万张28×28像素的图片
print(len(train_labels))   # 6万个标签
print(train_labels) # 0到9 的整数， 分别对应T-shirt/top 等

# 显示一张图片 28×28
#plt.figure()
#plt.imshow(train_images[0])
#plt.colorbar()  # 颜色柱  0- 255
#plt.grid(True)  # 网格  
#plt.show()

# 显示25张图片，图片大小  10×10
#plt.figure(figsize=(10,10))
#for i in range(25):
#    plt.subplot(5,5,i+1) # 添加子图， 5行5列的第i+1个位置
#    plt.xticks([]) # 不显示X坐标轴标尺
#    plt.yticks([]) #不显示Y坐标轴标尺
#    plt.grid(False)
#    plt.imshow(train_images[i],cmap=plt.cm.binary) # cm: colormap, 默认彩色，添加cmap=plt.cm.binary， 黑白
#    plt.xlabel(class_names[train_labels[i]]) # x抽标签
#plt.show()

# 1. 构造模型
model = keras.Sequential([
    keras.layers.Flatten(input_shape=(28,28)), #二维 28×28 转成一维782个像素点，这一层仅转换数据格式
    keras.layers.Dense(128,activation='relu'), #128个神经元
    keras.layers.Dense(10) #返回归属10个类型的概率值
])

#2. 编译模型, 优化器、损失函数和指标
model.compile(optimizer='adam',
              loss=tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
              metrics=['accuracy'])

#3. 训练模型，将训练数据输入模型，模型学习关联图形和标签
model.fit(train_images,train_labels,epochs=5)#模型适配数据

#4. 评估准确性
test_loss, test_acc = model.evaluate(test_images,  test_labels, verbose=2)
print('\nTest accuracy:', test_acc)

#5. 预测, 使用模型预测
probability_model = tf.keras.Sequential([model,tf.keras.layers.Softmax()])
predictions = probability_model.predict(test_images)
print(predictions[0]) # 10个数字的概率数组
np.argmax(predictions[0]) # 取最大值的下标


#5.1 图片预测的可视化显示
def plot_image(i,predictions_array,true_label,img):
    predictions_array,true_label,img = predictions_array,true_label[i],img[i]
    plt.grid(False)
    plt.xticks([])
    plt.yticks([])
    
    plt.imshow(img,cmap=plt.cm.binary)

    predicted_label = np.argmax(predictions_array)
    if predicted_label == true_label:#预测与实际相同
        color = 'blue'
    else:
        color = 'red'
    plt.xlabel("{} {:2.0f}% ({})".format(class_names[predicted_label], #预测的标签
                                        100*np.max(predictions_array), # 概率的最大值乘以100， 显示格式：整数2位，小数0位，后面加百分号。
                                        class_names[true_label]), #实际的标签
                                        color=color)  # 字体颜色
# 返回的10个数字的概率的可视化显示
def plot_value_array(i, predictions_array,true_label):
    predictions_array,true_label = predictions_array,true_label[i]
    plt.grid(False)
    plt.xticks(range(10)) #X轴， 0-10
    plt.yticks([])
    thisplot = plt.bar(range(10),predictions_array,color="#777777") # 柱状图
    plt.ylim([0,1]) # y轴值的范围
    predicted_label = np.argmax(predictions_array) # 预测的位置
    thisplot[predicted_label].set_color('red') #预测的柱的颜色
    thisplot[true_label].set_color('blue') #实际的柱的颜色， 与预测相同会覆盖预测的颜色

i=0
plt.figure(figsize=(6,3)) # 图片大小 6×3
plt.subplot(1,2,1) # 1行2列， 第1个位置
plot_image(i,predictions[i],test_labels,test_images) # 对预测的结果结合测试数据进行判断并显示
plt.subplot(1,2,2)
plot_value_array(i,predictions[i],test_labels)
plt.show()

