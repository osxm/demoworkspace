import os 
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3' # 不显示AVX， CUDA等警告

import tensorflow as tf

# 形状为(2,2)的二维变量
v =  tf.Variable([[1,2],[3,4]])
print(v)

# 二维常量
c =  tf.constant([[1,2],[3,4]])
print(c)
print(c.numpy())

# 3*3 元素全为0的常量
c = tf.zeros([3,3])
print(c)

#与c形状一样， 元素全为1的常量张量
c = tf.ones_like(c)
print(c)

# 2*3 ，元素全为6
tf.fill([2,3],6)

# tf.linespace 等间隔序列
s = tf.linspace(1.0,10.0,5) #从1.0 到 10.0 的等间隔5个数
print(s)

# 数字序列
s = tf.range(start=1,limit=10,delta=2)
print(s)

# 矩阵乘法
# tf.linalg.matmul(a, b) 

# 矩阵转置
#tf.linalg.matrix_transpose(c) 
