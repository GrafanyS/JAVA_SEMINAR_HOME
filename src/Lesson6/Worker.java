package Lesson6;

public class Worker {
    int count;
    int args;
    String name;
    String description;



    public Worker(){
        return;
    }

    public Worker(int count, int args, String name, String description) {
        this.count = count;
        this.args = args;
        this.name = name;
        this.description = description;
    }

    public Worker(int count, int args, String name) {
        this.count = count;
        this.args = args;
        this.name = name;
    }
    
    public Worker(int args, String name, String description) {
        this.args = args;
        this.name = name;
        this.description = description;
    }
    
    public Worker(String description, int count, String name) {
        this.count = count;
        this.name = name;
        this.description = description;
    }


    public Worker(int args, String name) {
        this.args = args;
        this.name = name;
    }
       
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getArgs() {
        return args;
    }
    public void setArgs(int args) {
        this.args = args;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
