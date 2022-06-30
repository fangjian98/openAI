# openCV 常用用法

# 理解级联分类器：分类器，判别某个事物是否属于某种分类的器件，两种结果：是、否
# 级联分类器： 可以理解为将N个单类的分类器串联起来。如果一个事物能属于这一系列串联起来的的所有分类器，则最终结果就是 是，若有一项不符，则判定为否。
# 比如人脸，它有很多属性，我们将每个属性做一成个分类器，如果一个模型符合了我们定义的人脸的所有属性，则我们人为这个模型就是一个人脸。那么这些属性是指什么呢？ 比如人脸需要有两条眉毛，两只眼睛，一个鼻子，一张嘴，一个大概U形状的下巴或者是轮廓等等
# haarcascades模型位于/data/haarcascades目录下

# 导入opencv库
import os
import cv2


# 识别图片中的人脸：使用 haarcascade_frontalface_default.xml
def face_detect(img_path):
    # 初始化模型
    detector = cv2.CascadeClassifier('../haarcascades/haarcascade_frontalface_default.xml')
    # 初始化窗口
    cv2.namedWindow('image', cv2.WINDOW_AUTOSIZE)
    # 读取图片
    img = cv2.imread(img_path)
    # 显示图片
    # cv2.imshow('image', img)
    # 转换为灰度图
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # 人脸检测
    dets = detector.detectMultiScale(img_gray, 1.1, 5)
    # 获取人脸框
    faces = []
    for i, d in enumerate(dets):
        x1 = d[0] if d[0] > 0 else 0
        y1 = d[1] if d[1] > 0 else 0
        x2 = d[0] + d[2] if d[0] + d[2] > 0 else 0
        y2 = d[1] + d[3] if d[1] + d[3] > 0 else 0
    # 显示人脸框
    cv2.rectangle(img, (x1, y1), (x2, y2), (0, 255, 0), 2)
    # 保存图片
    cv2.imwrite('../result/face_detect_1.jpg', img)
    # 显示图片标记人脸框
    # cv2.imshow('image', img)
    # 等待关闭窗口
    # cv2.waitKey(0)


# 人眼检测：使用 haarcascade_eye_tree_eyeglasses.xml
def eye_detect(img_path):
    # 初始化模型
    detector = cv2.CascadeClassifier('../haarcascades/haarcascade_eye_tree_eyeglasses.xml')
    # 初始化窗口
    cv2.namedWindow('image', cv2.WINDOW_AUTOSIZE)
    # 读取图片
    img = cv2.imread(img_path)
    # 显示图片
    # cv2.imshow('image', img)
    # 转换为灰度图
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # 人眼检测
    dets = detector.detectMultiScale(img_gray, 1.1, 5)
    # 获取人眼框
    faces = []
    for i, d in enumerate(dets):
        x1 = d[0] if d[0] > 0 else 0
        y1 = d[1] if d[1] > 0 else 0
        x2 = d[0] + d[2] if d[0] + d[2] > 0 else 0
        y2 = d[1] + d[3] if d[1] + d[3] > 0 else 0
    # 显示人脸框
    cv2.rectangle(img, (x1, y1), (x2, y2), (0, 255, 0), 2)
    # 保存图片
    cv2.imwrite('../result/eye_detect_1.jpg', img)
    # 显示图片标记人脸框
    cv2.imshow('image', img)
    # 等待关闭窗口
    cv2.waitKey(0)


def face_eye_detect(image_path):
    face_cascade = cv2.CascadeClassifier('../haarcascades/haarcascade_frontalface_default.xml')
    eye_cascade = cv2.CascadeClassifier('../haarcascades/haarcascade_eye.xml')
    img = cv2.imread(image_path)
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # 现在我们在图像中找到了脸部。如果找到面部，它会以Rect（x，y，w，h）的形式返回检测到的面部的位置。一旦我们获得了这些位置，
    # 我们就可以为脸部创建ROI并在此ROI上应用眼部检测（因为眼睛总是在脸上!!!）。
    faces = face_cascade.detectMultiScale(gray, 1.3, 5)
    for (x, y, w, h) in faces:
        img = cv2.rectangle(img, (x, y), (x + w, y + h), (255, 0, 0), 2)
        roi_gray = gray[y:y + h, x:x + w]
        roi_color = img[y:y + h, x:x + w]
        eyes = eye_cascade.detectMultiScale(roi_gray)
        for (ex, ey, ew, eh) in eyes:
            cv2.rectangle(roi_color, (ex, ey), (ex + ew, ey + eh), (0, 255, 0), 2)
    cv2.imwrite("../result/face_eye_detect.jpg", img)


def eye_detect_save(img_path, filename):
    # 初始化模型
    detector = cv2.CascadeClassifier('../haarcascades/haarcascade_eye_tree_eyeglasses.xml')
    # 读取图片
    img = cv2.imread(img_path)
    # 转换为灰度图
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # 人眼检测
    dets = detector.detectMultiScale(img_gray, 1.1, 5)
    # 获取人眼框
    faces = []
    for i, d in enumerate(dets):
        x1 = d[0] if d[0] > 0 else 0
        y1 = d[1] if d[1] > 0 else 0
        x2 = d[0] + d[2] if d[0] + d[2] > 0 else 0
        y2 = d[1] + d[3] if d[1] + d[3] > 0 else 0
    # 显示人脸框
    cv2.rectangle(img, (x1, y1), (x2, y2), (0, 255, 0), 2)
    # 保存图片
    save_path = '../result/' + filename
    cv2.imwrite(save_path, img)


# 人眼检测：使用 haarcascade_eye.xml
def eye_detect_2(img_path):
    # 初始化模型
    detector = cv2.CascadeClassifier('../haarcascades/haarcascade_eye.xml')
    # 初始化窗口
    cv2.namedWindow('image', cv2.WINDOW_AUTOSIZE)
    # 读取图片
    img = cv2.imread(img_path)
    # 显示图片
    # cv2.imshow('image', img)
    # 转换为灰度图
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # 人眼检测
    dets = detector.detectMultiScale(img_gray, 1.1, 5)
    # 获取人眼框
    faces = []
    for i, d in enumerate(dets):
        x1 = d[0] if d[0] > 0 else 0
        y1 = d[1] if d[1] > 0 else 0
        x2 = d[0] + d[2] if d[0] + d[2] > 0 else 0
        y2 = d[1] + d[3] if d[1] + d[3] > 0 else 0
    # 显示人脸框
    cv2.rectangle(img, (x1, y1), (x2, y2), (0, 255, 0), 2)
    # 保存图片
    cv2.imwrite('../result/eye_detect2_1.jpg', img)
    # 显示图片标记人脸框
    cv2.imshow('image', img)
    # 等待关闭窗口
    cv2.waitKey(0)


# 肖像检测：haarcascade_profileface.xml
def profile_face(img_path):
    # 初始化模型
    detector = cv2.CascadeClassifier('../haarcascades/haarcascade_profileface.xml')
    # 初始化窗口
    cv2.namedWindow('image', cv2.WINDOW_AUTOSIZE)
    # 读取图片
    img = cv2.imread(img_path)
    # 显示图片
    # cv2.imshow('image', img)
    # 转换为灰度图
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # 人眼检测
    dets = detector.detectMultiScale(img_gray, 1.1, 5)
    # 获取人眼框
    faces = []
    for i, d in enumerate(dets):
        x1 = d[0] if d[0] > 0 else 0
        y1 = d[1] if d[1] > 0 else 0
        x2 = d[0] + d[2] if d[0] + d[2] > 0 else 0
        y2 = d[1] + d[3] if d[1] + d[3] > 0 else 0
    # 显示人脸框
    cv2.rectangle(img, (x1, y1), (x2, y2), (0, 255, 0), 2)
    # 保存图片
    cv2.imwrite('../result/profile_face_6.jpg', img)
    # 显示图片标记人脸框
    cv2.imshow('image', img)
    # 等待关闭窗口
    cv2.waitKey(0)


# 微笑检测：haarcascade_smile.xml
def smile_detect(img_path):
    # 初始化模型
    detector = cv2.CascadeClassifier('../haarcascades/haarcascade_smile.xml')
    # 初始化窗口
    cv2.namedWindow('image', cv2.WINDOW_AUTOSIZE)
    # 读取图片
    img = cv2.imread(img_path)
    # 显示图片
    # cv2.imshow('image', img)
    # 转换为灰度图
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # 人眼检测
    dets = detector.detectMultiScale(img_gray, 1.1, 5)
    # 获取人眼框
    faces = []
    for i, d in enumerate(dets):
        x1 = d[0] if d[0] > 0 else 0
        y1 = d[1] if d[1] > 0 else 0
        x2 = d[0] + d[2] if d[0] + d[2] > 0 else 0
        y2 = d[1] + d[3] if d[1] + d[3] > 0 else 0
    # 显示人脸框
    cv2.rectangle(img, (x1, y1), (x2, y2), (0, 255, 0), 2)
    # 保存图片
    cv2.imwrite('../result/smile_detect_1.jpg', img)
    # 显示图片标记人脸框
    cv2.imshow('image', img)
    # 等待关闭窗口
    cv2.waitKey(0)


if __name__ == '__main__':
    print('PyCharm')
    # face_detect('../face/face01.jpg')
    # eye_detect('../face/face01.jpg')
    # eye_detect_2('../face/face01.jpg')
    # profile_face('../face/face06.jpg')
    # smile_detect('../face/face08.jpg')
    # 检测人脸和眼睛
    # face_eye_detect('../face/face12.jpg')
    # 遍历face文件夹 输出 人眼检测 输出 标记到 result文件夹
    for dirpath, dirnames, filenames in os.walk('../face'):
        for filename in filenames:
            print(os.path.join(dirpath, filename))
            eye_detect_save(os.path.join(dirpath, filename), filename)
