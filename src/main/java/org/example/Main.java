package org.example;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.printf("Hello and welcome!");
        Annot Annot=new Annot();
        int x =3;
        var methods =Annot.getClass().getDeclaredMethods();
        for (var method: methods){
            if (method.isAnnotationPresent(MyAnnotation.class)){
                int numberOfCalls =method.getAnnotation(MyAnnotation.class).numberOfCalls();
                method.setAccessible(true);
                for (int i = 0; i< numberOfCalls; i++){
                    if(method.getParameterCount()==1){
                        method.invoke(Annot,"call");
                    }else {
                        x = (int) method.invoke(Annot, x, 5);
                        System.out.println(x);
                    }
                }
            }
        }
        //
        System.out.println("////////////////////");
        try {
            Files.deleteIfExists(Path.of("Vladimirov/Nikita.txt"));
            Files.deleteIfExists(Path.of("Vladimirov/dir1/dir2/dir3/Nikita.txt"));
            Files.deleteIfExists(Path.of("Vladimirov/dir1/dir2/dir3"));
            Files.deleteIfExists(Path.of("Vladimirov/dir1/dir2/file2.txt"));
            Files.deleteIfExists(Path.of("Vladimirov/dir1/dir2"));
            Files.deleteIfExists(Path.of("Vladimirov/dir1/file1.txt"));
            Files.deleteIfExists(Path.of("Vladimirov/dir1"));
            Files.deleteIfExists(Path.of("Vladimirov"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //numberOfCalls
        String surname ="Vladimirov";
        try {
            Files.createDirectory(Path.of(surname));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //b
        String name = "Nikita";
        try {
            Files.createFile(Path.of(surname+"/"+name+".txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //c
        try {
            Files.createDirectories(Path.of(surname+"/dir1/dir2/dir3"));
            Files.copy(Path.of(surname+"/"+name+".txt"),
                    Path.of(surname+"/dir1/dir2/dir3/"+name+".txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //d
        try {
            Files.createFile(Path.of(surname+"/dir1/file1.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //e
        try {
            Files.createFile(Path.of(surname+"/dir1/dir2/file2.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //f
        Path a = Paths.get("C:\\Users\\mrkih\\IdeaProjects\\java_231_8\\Vladimirov");
        //System.out.println(numberOfCalls);
        try {
            Files.walkFileTree(Path.of(surname),new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)throws IOException{
                    System.out.println(file.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir,IOException ex)throws IOException{
                    if(ex==null){
                        System.out.println(dir.getFileName());
                        return FileVisitResult.CONTINUE;
                    }else{
                        throw ex;
                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //g
        try {
            Files.walkFileTree(Path.of(surname),new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)throws IOException{
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir,IOException ex)throws IOException{
                    if(ex==null){
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }else{
                        throw ex;
                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}