# 做数据处理和分析，清洗
import pandas as pd  
# 用来做可视化的工具 -→>能把数据变成图表imp9rt numpy.as.0P慈.用来做数咎理
import matplotlib.pyplot as plt  

#引入数据#   处理表头,  处理行索引
df = pd.read_csv("data.csv", header=None, index_col=O)
#把红球的号码拿出来
#列:从1到6拿到数据，
#行:所有的行的数据都是想要的数据
red_ball = df.loc[:, 1:6]
