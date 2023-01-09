/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Meteor
 */
public class compressor {
    public static void method(File file) throws IOException{ // file=variable
        //whatever the directory of input file will show the output in same directory.
        String filedirectory= file.getParent(); //getparent() will return the address path of input file from system
        
        //this line will get and read file from system
        // we obtain input bytes from a file & return in bytes(we are going to read byte oriented data)
        FileInputStream fis=new FileInputStream(file); 
        
        //the output file which we get will be stored in filedirectory
        //Compressedfile.gz is name of output file will be inside filedirectory after it is compressed.
        FileOutputStream fos=new FileOutputStream(filedirectory+"/endless_inf_Compressedfile.gz"); 
        
        //GZIP= output file i.e compressed stored in package of gzip as gz extension
        // we hve input bytes but now we need to compress those output bytes
        // y fos bcoz we will perform byte operation on compressed file.
        GZIPOutputStream gzipOS=new GZIPOutputStream(fos);
        
        //we need to store those bytes, throughthis we gonna read, write bytes
        byte[] buffer =new byte[1024];
        int len; // responsile to read the whole length
        
        //while reading this file gonna store len of file, iterate over that also
        // reading the input file n storing in buffer upto when len !=-1
        while((len=fis.read(buffer)) != -1){
            // write back into output file using gzip
            gzipOS.write(buffer,0,len); //offset means starting point of character from where i want to write the file
            // so no data loss, so start at 0 end at len.
        }
        gzipOS.close();//zip file closed
        fos.close();// output file closed
        fis.close();
        
    }
    public static void main(String[] args) throws IOException{
        File path=new File("/OneDrive/Documents/NetBeansProjects/Compressor-decompressor/endless_inf.txt");
        method(path);
    }
}
