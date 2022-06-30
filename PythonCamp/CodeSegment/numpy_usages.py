# 关于numpy
# NumPy(Numerical Python) 是 Python 语言的一个扩展程序库，支持大量的维度数组与矩阵运算，此外也针对数组运算提供大量的数学函数库。
# NumPy 是一个科学计算的工具包，它提供了一组用于处理数组的函数，以及用于处理矩阵的函数。
# NumPy 是一个运行速度非常快的数学库，主要用于数组计算，包含：
# 1. 一个强大的N维数组对象 ndarray
# 2. 广播功能函数
# 3. 整合 C/C++/Fortran 代码的工具
# 4. 线性代数、傅里叶变换、随机数生成等功能


# numpy的使用

# 导入numpy
import numpy as np
from matplotlib import pyplot as plt

# 创建2个一维数组
a1 = np.array([1, 2, 3, 4, 5])
a2 = np.array([6, 7, 8, 9, 10])

# 创建2个二维数组
b1 = np.array([[1, 5], [6, 7]])
b2 = np.array([[11, 13], [18, 19]])

# 创建一个空数组
c = np.empty((2, 3))

# 创建一个全0数组
d = np.zeros((2, 3))

# 创建一个全1数组
e = np.ones((2, 3))

# 创建一个随机数组
f = np.random.random((2, 3))

# 创建一个随机整数数组
g = np.random.randint(0, 10, (2, 3))

# 创建一个随机浮点数组
h = np.random.rand(2, 3)


# NumPy 矩阵库(Matrix)
# NumPy 提供了一个矩阵库，可以用来处理矩阵运算。
# NumPy 矩阵库提供了一个矩阵对象，它是一个二维数组，其中每个元素都是一个浮点数。
# NumPy 矩阵库提供了一些矩阵运算的函数，包括：
# 1. 矩阵的加减乘除
# 2. 矩阵的点积
# 3. 矩阵的转置
# 4. 矩阵的逆
# 5. 矩阵的行列式
# 6. 矩阵的秩
# 7. 矩阵的求逆
# 8. 矩阵的求逆（使用SVD）
# 9. 矩阵的求逆（使用QR）
# 10. 矩阵的求逆（使用LU）
# 11. 矩阵的求逆（使用Cholesky）
import numpy.matlib 
print (np.matlib.empty((2,2)))

# NumPy 线性代数用法
# NumPy 提供了线性代数函数库 linalg,该库包含了线性代数所需的所有功能

# dot 两个数组的点积
np.dot(b1, b2)
print(np.dot(b1, b2))

# vdot 两个向量的点积
np.vdot(b1, b2)
print(np.vdot(b1, b2))

# inner 两个数组的内积
np.inner(b1, b2)

# matmul 两个数组的矩阵乘法
np.matmul(b1, b2)

# determinant 矩阵的行列式
np.linalg.det(b1)

# solve 矩阵的解
np.linalg.solve(b1, b2)

# inv 矩阵的逆
np.linalg.inv(b1)

# Matplotlib 是 Python 的绘图库。 它可与 NumPy 一起使用，提供了一种有效的 MatLab 开源替代方案。
# 实例中，np.arange() 函数创建 x 轴上的值。y 轴上的对应值存储在另一个数组对象 y 中。
# 这些值使用 matplotlib 软件包的 pyplot 子模块的 plot() 函数绘制。图形由 show() 函数显示。
x = np.arange(1, 11)
y = 2 * x + 5
plt.title("Matplotlib demo")
plt.xlabel("x axis caption")
plt.ylabel("y axis caption")
plt.plot(x, y)
plt.show()

# NumPy 排序、条件刷选函数

# NumPy 排序：sort
# numpy.sort(a, axis, kind, order)
# a: 要排序的数组
# axis: 沿着它排序数组的轴，如果没有数组会被展开，沿着最后的轴排序， axis=0 按列排序，axis=1 按行排序
# kind: 默认为'quicksort'（快速排序）
# order: 如果数组包含字段，则是要排序的字段

# numpy.sort() 函数返回输入数组的排序副本
a1 = np.array([7, 2, 0, 9, 3])
np.sort(a1)
print(np.sort(a1))

# numpy.argsort() 函数返回的是数组值从小到大的索引值
np.argsort(a1)
print(np.argsort(a1))

# numpy.lexsort() 用于对多个序列进行排序。把它想象成对电子表格进行排序，每一列代表一个序列，排序时优先照顾靠后的列
# nm =  ('raju','anil','ravi','amar') 
# dv =  ('f.y.',  's.y.',  's.y.',  'f.y.') 
# ind = np.lexsort((dv,nm))  
np.lexsort(a1)
print(np.lexsort(a1))

# numpy.argmax() 和 numpy.argmin()函数分别沿给定轴返回最大和最小元素的索引
np.argmax(a1)
np.argmin(a1)
print(np.argmax(a1))
print(np.argmin(a1))