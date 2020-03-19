package cn.jeremy.common.utils;

import java.io.File;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * 文件压缩工具类
 *
 * @author fengjiangtao
 * @date 2020/3/15 17:22
 */
public class ZipUtil
{

    /**
     * 压缩文件夹到当前目录下
     *
     * @param folder
     * @author fengjiangtao
     */
    public static void zipFolder(String folder)
        throws ZipException
    {
        String file = folder.concat(".zip");
        if (FileUtil.isFileExists(file))
        {
            FileUtil.deleteFile(file);
        }
        new ZipFile(file).addFolder(new File(folder));
    }

    /**
     * 解压压缩文件到当前文件夹
     *
     * @param zipPath
     * @author fengjiangtao
     */
    public static void unZipFolder(String zipPath)
        throws ZipException
    {
        unZipFolder(zipPath, false);
    }

    /**
     * 解压压缩文件到当前文件夹
     *
     * @param zipPath
     * @author fengjiangtao
     */
    public static void unZipFolder(String zipPath, boolean delZip)
        throws ZipException
    {
        String dir = zipPath.substring(0, zipPath.length() - 4);
        if (FileUtil.isFileExists(dir))
        {
            FileUtil.deleteDir(dir);
        }
        new ZipFile(zipPath).extractAll(zipPath.substring(0, zipPath.lastIndexOf("/")));
        if (delZip)
        {
            FileUtil.deleteFile(zipPath);
        }
    }
}
