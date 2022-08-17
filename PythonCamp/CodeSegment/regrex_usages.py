import re

# 正则表达式将一串数字中每2位添加一个冒号,结尾不加冒号
def add_colon_end(number):
    return re.sub(r'(\d{2})', r'\1:', number)[:-1]

print(add_colon_end('090502'))
