/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author Meteor
 */
public class decompressor {
    public static void method(File file) throws IOException{
        String fileDirectory= file.getParent();
        FileInputStream fis= new FileInputStream(file);//contains compressed file
        
        //we need to read those compressed input bytes  n write to gzip inputstream
        GZIPInputStream gzipIS= new GZIPInputStream(fis);
        FileOutputStream fos=new  FileOutputStream(fileDirectory+"/endless_inf_Decompressedfile");
        
        //store the file in byte array
        byte[] buffer=new byte[1024];
        
        int len;
        
        // we have to  read the compressed file so gzip which is unzipped
        //and write back to fos
        while((len=gzipIS.read(buffer)) !=-1){
            fos.write(buffer, 0,len);     
        }
        gzipIS.close();
        fis.close();
        fos.close();     
    }
    
    public static void main(String[] args) throws IOException{
        File path=new File("/OneDrive/Documents/NetBeansProjects/Compressor-decompressor/endless_inf_Compressedfile.gz");
        method(path);    
    }
}
