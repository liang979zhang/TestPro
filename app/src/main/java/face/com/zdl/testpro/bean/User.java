package face.com.zdl.testpro.bean;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Administrator on 2018/4/26.
 */

public class User extends RealmObject {

    private int id;
    private String name;
    private int age;
    private RealmList<Dog> dogs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RealmList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(RealmList<Dog> dogs) {
        this.dogs = dogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
