package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;

public class HDFSFSAPP {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:9000");
        FileSystem fs = FileSystem.get(conf);
        fs.createNewFile(new Path("/file2"));
        fs.delete(new Path("/bddcFile"));
        RemoteIterator< LocatedFileStatus> it =  fs.listFiles(new Path("/file/file1"),false);
        while(it.hasNext()){
            LocatedFileStatus next = it.next();
            System.out.println(next.getOwner());
        }

        FileStatus[]  fileStatus = fs.listStatus(new Path("/file"));
        for(FileStatus fileStatus1:fileStatus){
            System.out.println(fileStatus1.toString());
        }

        fs.copyToLocalFile(new Path("/file/file1"),new Path("./"));


    }
}
