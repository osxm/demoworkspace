import os 
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3' # 不显示AVX， CUDA等警告

import tensorflow as tf

w = tf.Variable([1.0]) # 需要为浮点型
with tf.GradientTape() as tape:
    loss = w * w  #1.0的平方

grad = tape.gradient(loss,w) # 微分， 导数。 1.0的平方的微分是2.0。梯度