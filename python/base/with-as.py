# 简单处理
file = open("1.txt")
data = file.read()
file.close()


# 增加异常处理
try:
    f = open('1.txt')
except:
    print 'fail to open'
    exit(-1)
finally
    f.close()


# 使用with
with open("/tmp/1.txt") as file:
    data = file.read()
