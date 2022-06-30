# 关于Pandas
# Pandas是一个基于NumPy的数据分析工具包，它提供了一种高效的数据分析方法，并且可以用于大型数据集。
# Pandas 的主要数据结构是 Series （一维数据）与 DataFrame（二维数据），这两种数据结构足以处理金融、统计、社会科学、工程等领域里的大多数典型用例。
# Series 是一种类似于一维数组的对象，它由一组数据（各种Numpy数据类型）以及一组与之相关的数据标签（即索引）组成。
# DataFrame 是一种类似于二维数组的对象，它由一组数据（各种Numpy数据类型）以及一组与之相关的数据标签（即索引）组成。DataFrame 是一个表格型的数据结构，它含有一组有序的列，
# 每列可以是不同的值类型（数值、字符串、布尔型值）。DataFrame 既有行索引也有列索引，它可以被看做由 Series 组成的字典（共同用一个索引）。

# 导入Pandas
import pandas as pd

# Pandas 数据结构 - Series
# Pandas Series 类似表格中的一个列（column），类似于一维数组，可以保存任何数据类型。
# Series 由索引（index）和列组成，函数如下：
# pandas.Series( data, index, dtype, name, copy)
# 1. data：一组数据(ndarray 类型)。
# 2. index：数据索引标签，如果不指定，默认从 0 开始。
# 3. dtype：数据类型，默认会自己判断。
# 4. name：设置名称。
# 5. copy：拷贝数据，默认为 False。

# 创建一个Series
s = pd.Series([1, 2, 3], index=['a', 'b', 'c'])
print(s)

# 创建一个空的 Series
s = pd.Series()
print(s)
# 创建一个空的 Series，并初始化为一个字典
s = pd.Series({'a': 1, 'b': 2, 'c': 3})
print(s)
# 创建一个空的 Series，并初始化为一个列表
s = pd.Series([1, 2, 3])
print(s)
# 创建一个空的 Series，并初始化为一个字符串
s = pd.Series('hello')
print(s)
# 创建一个空的 Series，并初始化为一个数字
s = pd.Series(1)
print(s)
# 创建一个空的 Series，并初始化为一个布尔型值
s = pd.Series(True)
print(s)

# Pandas 数据结构 - DataFrame
# DataFrame 是一个表格型的数据结构，它含有一组有序的列，每列可以是不同的值类型（数值、字符串、布尔型值）。DataFrame 既有行索引也有列索引，它可以被看做由 Series 组成的字典（共同用一个索引）。
# Pandas DataFrame 是一个二维的数组结构，类似二维数组。
# DataFrame 构造方法如下：
# pandas.DataFrame( data, index, columns, dtype, copy)
# data：一组数据(ndarray、series, map, lists, dict 等类型)。
# index：索引值，或者可以称为行标签。
# columns：列标签，默认为 RangeIndex (0, 1, 2, …, n) 。
# dtype：数据类型。
# copy：拷贝数据，默认为 False。

# 创建一个Series
s = pd.Series([1, 2, 3], index=['a', 'b', 'c'])
print(s)

# 创建一个DataFrame
data = [['Google', 10], ['Runoob', 12], ['Wiki', 13]]
df = pd.DataFrame(data, columns=['Site', 'Age'], dtype=float)
print(df)

# 创建一个空的 DataFrame
df = pd.DataFrame()
print(df)
# 创建一个空的 DataFrame，并初始化为一个字典
dict = {'a': 1, 'b': 2, 'c': 3}
data = pd.DataFrame(list(dict.items()))
print(data)
# 创建一个空的 DataFrame，并初始化为一个列表
df = pd.DataFrame([1, 2, 3])
print(df)

# Pandas CSV 文件
# CSV（Comma-Separated Values，逗号分隔值，有时也称为字符分隔值，因为分隔字符也可以不是逗号），其文件以纯文本形式存储表格数据（数字和文本）。
# CSV 是一种通用的、相对简单的文件格式，被用户、商业和科学广泛应用。Pandas 可以很方便的处理 CSV 文件，

# 读取csv
# df = pd.read_csv('nba.csv')
# 输出前5行和后5行，其他省略
print(df)
# 输出全部
print(df.to_string())

# 三个字段 name, site, age
nme = ["Google", "Runoob", "Taobao", "Wiki"]
st = ["www.google.com", "www.runoob.com", "www.taobao.com", "www.wikipedia.org"]
ag = [90, 40, 80, 98]
# 字典
dict = {'name': nme, 'site': st, 'age': ag}
df = pd.DataFrame(dict)
# 保存 dataframe
df.to_csv('site.csv')

# 数据处理
# head() 方法，输出前5行数据
print(df.head())
# tail() 方法，输出后5行数据
print(df.tail())
# info() 方法，输出DataFrame的情况
print(df.info())
# describe() 方法，输出DataFrame的描述性统计信息
print(df.describe())
# shape() 方法，输出DataFrame的行数和列数
print(df.shape)
# index() 方法，输出DataFrame的索引
print(df.index)
# columns() 方法，输出DataFrame的列名
print(df.columns)
# values() 方法，输出DataFrame的值
print(df.values)
# dtypes() 方法，输出DataFrame的数据类型
print(df.dtypes)
# isnull() 方法，输出DataFrame的空值信息
print(df.isnull())
# notnull() 方法，输出DataFrame的非空值信息
print(df.notnull())
# dropna() 方法，删除DataFrame的空值行
print(df.dropna())
# dropna(how='all') 方法，删除DataFrame的所有空值行
print(df.dropna(how='all'))
# dropna(thresh=) 方法，删除DataFrame的空值行，如果有超过thresh行的空值，则删除该行
print(df.dropna(thresh=2))
# dropna(subset=) 方法，删除DataFrame的空值行，只删除指定列的空值
print(df.dropna(subset=['age']))
# fillna() 方法，填充DataFrame的空值
print(df.fillna(value=0))
# fillna(method='ffill') 方法，填充DataFrame的空值，前面的值
print(df.fillna(method='ffill'))
# fillna(method='bfill') 方法，填充DataFrame的空值，后面的值
print(df.fillna(method='bfill'))
# fillna(method='pad') 方法，填充DataFrame的空值，前面的值
print(df.fillna(method='pad'))
# fillna(method='backfill') 方法，填充DataFrame的空值，后面的值
print(df.fillna(method='backfill'))
# fillna(method='ffill', limit=) 方法，填充DataFrame的空值，前面的值，最多填充limit行
print(df.fillna(method='ffill', limit=2))
# fillna(method='bfill', limit=) 方法，填充DataFrame的空值，后面的值，最多填充limit行
print(df.fillna(method='bfill', limit=2))
# fillna(method='pad', limit=) 方法，填充DataFrame的空值，前面的值，最多填充limit行
print(df.fillna(method='pad', limit=2))

# Pandas JSON
# JSON（JavaScript Object Notation，JavaScript 对象表示法），是存储和交换文本信息的语法，类似 XML。
# JSON 比 XML 更小、更快，更易解析，Pandas 可以很方便的处理 JSON 数据。

# 读取json
# df = pd.read_json('sites.json')   
# print(df.to_string())

data = [
    {
        "id": "A001",
        "name": "菜鸟教程",
        "url": "www.runoob.com",
        "likes": 61
    },
    {
        "id": "A002",
        "name": "Google",
        "url": "www.google.com",
        "likes": 124
    },
    {
        "id": "A003",
        "name": "淘宝",
        "url": "www.taobao.com",
        "likes": 45
    }
]
df = pd.DataFrame(data)
print(df)


# Pandas 数据清洗
# 数据清洗是对一些没有用的数据进行处理的过程。很多数据集存在数据缺失、数据格式错误、错误数据或重复数据的情况，如果要对使数据分析更加准确，就需要对这些没有用的数据进行处理。

# Pandas 清洗空值:如果我们要删除包含空字段的行，可以使用 dropna() 方法，语法格式如下：
# DataFrame.dropna(axis=0, how='any', thresh=None, subset=None, inplace=False)

# Pandas 清洗格式错误数据
# 数据格式错误的单元格会使数据分析变得困难，甚至不可能。我们可以通过包含空单元格的行，或者将列中的所有单元格转换为相同格式的数据。
# df['Date'] = pd.to_datetime(df['Date'])

# Pandas 清洗错误数据
# 数据错误也是很常见的情况，我们可以对错误的数据进行替换或移除。
# df.loc[2, 'age'] = 30

# Pandas 清洗重复数据
# 如果我们要清洗重复数据，可以使用 duplicated() 和 drop_duplicates() 方法。如果对应的数据是重复的，duplicated() 会返回 True，否则返回 False。
# print(df.duplicated())