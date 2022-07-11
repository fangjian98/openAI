package CodeSegment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class FileUtils{
    public static void main(String[] args) {
        System.out.println("Hello File Utils!");        
    }

    //写入字符串到文件
    public static void writeStringToFile(String filePath, String content) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //读取文件内容到字符串
    public static String readFileToString(String filePath) {
        StringBuffer sb = new StringBuffer();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return null;
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    //获取文件后缀名
    public static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    //获取文件名
    public static String getFileName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    //获取文件MIME类型
    public static String getFileMimeType(String fileName) {
        String fileExtension = getFileExtension(fileName);
        if (fileExtension.equals("jpg") || fileExtension.equals("jpeg")) {
            return "image/jpeg";
        } else if (fileExtension.equals("png")) {
            return "image/png";
        } else if (fileExtension.equals("gif")) {
            return "image/gif";
        } else if (fileExtension.equals("bmp")) {
            return "image/bmp";
        } else if (fileExtension.equals("pdf")) {
            return "application/pdf";
        } else if (fileExtension.equals("doc")) {
            return "application/msword";
        } else if (fileExtension.equals("docx")) {
            return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        } else if (fileExtension.equals("xls")) {
            return "application/vnd.ms-excel";
        } else if (fileExtension.equals("xlsx")) {
            return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        } else if (fileExtension.equals("ppt")) {
            return "application/vnd.ms-powerpoint";
        } else if (fileExtension.equals("pptx")) {
            return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
        } else if (fileExtension.equals("txt")) {
            return "text/plain";
        } else if (fileExtension.equals("html")) {
            return "text/html";
        }
        return "*/*";
    }

    //获取文件大小
    public static long getFileSize(String fileName) {
        File file = new File(fileName);
        return file.length();
    }

    //获取文件创建时间
    public static long getFileCreateTime(String fileName) {
        File file = new File(fileName);
        return file.lastModified();
    }

    //读取文件内容
    public static String readFile(String fileName) {
        File file = new File(fileName);
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    //写入文件内容
    public static void writeFile(String fileName, String content) {
        File file = new File(fileName);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(content);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //复制文件
    public static void copyFile(String srcFileName, String destFileName) {
        File srcFile = new File(srcFileName);
        File destFile = new File(destFileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(srcFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destFile));
            String line = "";
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //复制文件 using OutputStream and InputStream
    public static void copyFileStream(String srcFileName, String destFileName) {
        try {
            File srcFile = new File(srcFileName);
            File destFile = new File(destFileName);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            byte[] buf = new byte[1024];
            int c;
            while ((c = fis.read(buf)) != -1) {
                fos.write(buf, 0, c);
            }
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除文件
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        file.delete();
    }

    //移动文件
    public static void moveFile(String srcFileName, String destFileName) {
        copyFile(srcFileName, destFileName);
        deleteFile(srcFileName);
    }

    //创建文件夹
    public static void createDir(String dirName) {
        File dir = new File(dirName);
        dir.mkdir();
    }

    //创建文件
    public static void createFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //压缩文件 using ZipOutputStream
    public static void zipFile(String srcFileName, String destFileName) {
        try {
            File srcFile = new File(srcFileName);
            File destFile = new File(destFileName);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(destFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            zos.putNextEntry(new ZipEntry(srcFile.getName()));
            FileInputStream fis = new FileInputStream(srcFile);
            byte[] buf = new byte[1024];
            int c;
            while ((c = fis.read(buf)) != -1) {
                zos.write(buf, 0, c);
            }
            zos.closeEntry();
            fis.close();
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //解压文件 using ZipInputStream
    public static void unzipFile(String srcFileName, String destDirName) {
        try {
            File srcFile = new File(srcFileName);
            File destDir = new File(destDirName);
            if (!destDir.exists()) {
                destDir.mkdir();
            }
            ZipInputStream zis = new ZipInputStream(new FileInputStream(srcFile));
            ZipEntry entry = zis.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                File destFile = new File(destDir, fileName);
                if (entry.isDirectory()) {
                    destFile.mkdir();
                } else {
                    File parentFile = destFile.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    FileOutputStream fos = new FileOutputStream(destFile);
                    byte[] buf = new byte[1024];
                    int c;
                    while ((c = zis.read(buf)) != -1) {
                        fos.write(buf, 0, c);
                    }
                    fos.close();
                }
                zis.closeEntry();
                entry = zis.getNextEntry();
            }
            zis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //压缩文件夹 using ZipOutputStream
    public static void zipDir(String srcDirName, String destFileName) {
        try {
            File srcDir = new File(srcDirName);
            File destFile = new File(destFileName);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(destFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            File[] files = srcDir.listFiles();
            for (File file : files) {
                String fileName = file.getName();
                if (file.isDirectory()) {
                    zipDir(srcDirName + "/" + fileName, destFileName);
                } else {
                    zos.putNextEntry(new ZipEntry(fileName));
                    FileInputStream fis = new FileInputStream(file);
                    byte[] buf = new byte[1024];
                    int c;
                    while ((c = fis.read(buf)) != -1) {
                        zos.write(buf, 0, c);
                    }
                    fis.close();
                    zos.closeEntry();
                }
            }
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //解压文件夹 using ZipInputStream
    public static void unzipDir(String srcFileName, String destDirName) {
        try {
            File srcFile = new File(srcFileName);
            File destDir = new File(destDirName);
            if (!destDir.exists()) {
                destDir.mkdir();
            }
            ZipInputStream zis = new ZipInputStream(new FileInputStream(srcFile));
            ZipEntry entry = zis.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                File destFile = new File(destDir, fileName);
                if (entry.isDirectory()) {
                    destFile.mkdir();
                } else {
                    File parentFile = destFile.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    FileOutputStream fos = new FileOutputStream(destFile);
                    byte[] buf = new byte[1024];
                    int c;
                    while ((c = zis.read(buf)) != -1) {
                        fos.write(buf, 0, c);
                    }
                    fos.close();
                }
                zis.closeEntry();
                entry = zis.getNextEntry();
            }
            zis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Uri转File
    // public static File uri2File(Context context, Uri uri) {
    //     String scheme = uri.getScheme();
    //     String authority = uri.getAuthority();
    //     String path = uri.getPath();
    //     if (scheme.equals("file")) {
    //         return new File(path);
    //     } else if (scheme.equals("content")) {
    //         String[] proj = {MediaStore.Images.Media.DATA};
    //         Cursor cursor = context.getContentResolver().query(uri, proj, null, null, null);
    //         int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
    //         cursor.moveToFirst();
    //         return new File(cursor.getString(column_index));
    //     } else {
    //         return null;
    //     }
    // }

    //File转Uri
    // public static Uri file2Uri(Context context, File file) {
    //     return Uri.fromFile(file);
    // }

    //Url转File
    public static File url2File(String url) {
        try {
            File file = new File(url);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //File转Url
    public static String file2Url(File file) {
        return file.getAbsolutePath();
    }

    //Android Url转File
    // public static File androidUrl2File(Context context, Uri uri) {
    //     String path = uri.getPath();
    //     return new File(path);
    // }

    //Android Url转Uri
    // public static Uri androidUrl2Uri(Context context, Uri uri) {
    //     String path = uri.getPath();
    //     return Uri.fromFile(new File(path));
    // }

    //文件加密
    public static String encryptFile(String filePath, String key) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            fis.close();
            byte[] encryptBytes = encrypt(bytes, key);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(encryptBytes);
            fos.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //encrypt
    private static byte[] encrypt(byte[] bytes, String key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptBytes = cipher.doFinal(bytes);
            return encryptBytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //文件解密
    public static String decryptFile(String filePath, String key) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            fis.close();
            byte[] decryptBytes = decrypt(bytes, key);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(decryptBytes);
            fos.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //decrypt
    private static byte[] decrypt(byte[] bytes, String key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptBytes = cipher.doFinal(bytes);
            return decryptBytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //文件遍历
    public static void listFile(File file, List<File> fileList) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                listFile(f, fileList);
            }
        } else {
            fileList.add(file);
        }
    }
}