import os 
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3' # 不显示AVX， CUDA等警告

# 导入
import tensorflow as tf
import tensorflow_datasets as tfds

# 导入其他库
import matplotlib.pyplot as plt # 一种2D绘图库
import numpy as np  # 数值计算的扩展，包括数学函数
import math #数学库

#print(tf.__version__)

#2. 下载数据,包括训练数据和测试数据
dataset, metadata = tfds.load('fashion_mnist',as_supervised=True,with_info=True)
train_dataset,test_dataset = dataset['train'],dataset['test']
class_names = ['T-shirt/top', 'Trouser', 'Pullover', 'Dress', 'Coat', 
               'Sandal',      'Shirt',   'Sneaker',  'Bag',   'Ankle boot']

# 3.数据预处理
num_train_examples = metadata.splits['train'].num_examples # 训练数据集数量
num_test_examples = metadata.splits['test'].num_examples # 测试数据集数量 ，数据会放入C:\Users\xx\tensorflow_datasets\fashion_mnist\3.0.0
print("训练数据集的数量：{}".format(num_train_examples)) #60000
print("测试数据集的数量：{}".format(num_test_examples)) #10000

# 4. 标准化
#自定义归一化函数
def normalize(images,labels):
    images = tf.cast(images,tf.float32) 
    images /= 255
    return images ,labels 
#使用函数作为参数，归一化训练数据集和测试数据集
train_dataset =  train_dataset.map(normalize)
test_dataset  =  test_dataset.map(normalize)

# 5. 查看标准化后的数据的前25个
plt.figure(figsize=(10,10)) # 创建一个figure对象
i = 0
for(image,label) in test_dataset.take(25): #测试数据的20笔
    image = image.numpy().reshape((28,28)) 
    plt.subplot(5,5,i+1)
    plt.xticks([]) 
    plt.yticks([])
    plt.grid(False)
    plt.imshow(image,cmap=plt.cm.binary)
    plt.xlabel(class_names[label]) # 设置X轴的标签
    i += 1
plt.show()

#6. 定义模型， 3层模型
model = tf.keras.Sequential([
    tf.keras.layers.Flatten(input_shape=(28,28,1)),  # 输入层
    tf.keras.layers.Dense(128, activation = tf.nn.relu), # 隐藏层
    tf.keras.layers.Dense(10,activation =tf.nn.softmax) # 10节点的softmax层，输出层
])

#7. 模型编译
model.compile(optimizer='adam', loss='sparse_categorical_crossentropy',metrics=['accuracy'])

#8. 训练模型， epochs 参数控制训练次数
BATCH_SIZE = 32
train_dataset = train_dataset.repeat().shuffle(num_train_examples).batch(BATCH_SIZE) #打乱数据集
test_dataset = test_dataset.batch(BATCH_SIZE) # 每批用32个图形和标签数据
model.fit(train_dataset,epochs=5,steps_per_epoch=math.ceil(num_test_examples/BATCH_SIZE))

#9.模型评估
test_loss,test_accuracy = model.evaluate(test_dataset,steps=math.ceil(num_test_examples/BATCH_SIZE))
print('Accuracy on test dataset:',test_accuracy)

#10. 模型预测
#.结果可视化
# 预测标签（概率最大的那个标签）和实际标签一致，则字似蓝色，否则是红色
def plot_image(i, predications_array,true_labels,images):
    predications_array,true_label,img = predications_array[i],true_labels[i],images[i]
    plt.grid(False)
    plt.xticks([])
    plt.yticks([])

    plt.imshow(img[...,0],cmap=plt.cm.binary)
    
    predicted_label = np.argmax(predications_array)
    if predicted_label == true_label:
        color = 'blue'
    else:
        color = 'red'

    plt.xlabel("{} {:2.0f}% ({})".format(class_names[predicted_label],
                                100*np.max(predications_array),
                                class_names[true_label]),
                                color=color)

def plot_value_array(i, predictions_array, true_label):
  predictions_array, true_label = predictions_array[i], true_label[i]
  plt.grid(False)
  plt.xticks([])
  plt.yticks([])
  thisplot = plt.bar(range(10), predictions_array, color="#777777")
  plt.ylim([0, 1]) 
  predicted_label = np.argmax(predictions_array)
 
  thisplot[predicted_label].set_color('red')
  thisplot[true_label].set_color('blue')

  #


for test_images,test_labels in test_dataset.take(1):
    test_images = test_images.numpy()
    test_labels = test_labels.numpy()
    predictions = model.predict(test_images)
    num_rows = 5
    num_cols = 3
    num_images = num_rows*num_cols
    plt.figure(figsize=(2*2*num_cols, 2*num_rows))
    for i in range(num_images):
        plt.subplot(num_rows, 2*num_cols, 2*i+1)
        plot_image(i, predictions, test_labels, test_images)
        plt.subplot(num_rows, 2*num_cols, 2*i+2)
        plot_value_array(i, predictions, test_labels)    

