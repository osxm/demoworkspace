import binascii
import numpy as numpy
import cv2 # 视觉库，需要安装 pip install opencv-python

with open('data/t10k-images.idx3-ubyte','rb') as f:
    file = f.read() # String 类型
    # print(file)
    #1. 幻数
    magic_number=file[:4] # 字节类型 ，\x00\x00\x08\x03 
    #print("magic_number= {}".format(magic_number))
    print("magic_number="+str(magic_number)) # str()转换为字符串

    #print(binascii.b2a_hex(magic_number).decode())
    str_magic_number = str(magic_number)
    hex_magic_number = binascii.b2a_hex(magic_number).decode()#z转换为16进制
    int_magic_number = int(hex_magic_number,16) #转换为十进制
    print(int_magic_number)  # 2051 , 文件的幻数

    #2. 图像数量
    num_images = int(binascii.b2a_hex(file[4:8]).decode(),16)
    print(num_images)  # 10000

     #3. 图像高度
    height_images = int(binascii.b2a_hex(file[8:12]).decode(),16)
    print(height_images)  # 

    #4. 图像宽度
    width_images = int(binascii.b2a_hex(file[12:16]).decode(),16)
    print(width_images)  # 


    #5. 第1张图片的像素
    image1 = [binascii.b2a_hex(file[12:16]).decode() for item in file[16:16+784]]
    print(len(image1)) # 数组长度 784
