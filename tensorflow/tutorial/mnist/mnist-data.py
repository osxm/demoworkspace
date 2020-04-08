#1. 导入TensorFlow
import tensorflow as tf
#1.2 matplotlib
import matplotlib.pyplot as plt


mnist = tf.keras.datasets.mnist #2. 通过keras使用数据集
(x_train, y_train), (x_test, y_test) = mnist.load_data() # 载入数据

#3. 显示第一张图
plt.figure()
plt.imshow(x_train[0])
plt.show()