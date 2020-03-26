import tensorflow as tf

a = tf.constant(1)
b= tf.constant(2)
c = tf.add(a,b)

session = tf.Session()
sum = session.run(c)
print(sum)
session.close()