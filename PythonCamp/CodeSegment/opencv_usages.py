# openCV 常用用法

# 导入opencv库
import cv2

# 识别图片中的人脸
def face_detect(img_path):
    # 初始化模型
    detector = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
    # 初始化窗口
    cv2.namedWindow('image', cv2.WINDOW_AUTOSIZE)
    # 读取图片
    img = cv2.imread(img_path)
    # 显示图片
    cv2.imshow('image', img)
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


if __name__ == '__main__':
    face_detect('./face.jpg')
    print('PyCharm')