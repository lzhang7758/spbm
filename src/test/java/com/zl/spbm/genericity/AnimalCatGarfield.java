package com.zl.spbm.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzhang
 * @Date: 2019/9/30 13:25
 */
public class AnimalCatGarfield {
    public static void main(String[] args) {

        //第一段：
        List<Animal> animalList = new ArrayList<>();
        List<Cat> catList = new ArrayList<>();
        List<Garfield> garfieldList = new ArrayList<>();

        animalList.add(new Animal());
        catList.add(new Cat());
        garfieldList.add(new Garfield());

        //第二段
        //只能赋值Cat或Cat的子级
//        List<? extends Cat> extendsCatFromAnimal = animalList;
        List<? super Cat> superCatFromAnimal = animalList;

        List<? extends Cat> extendsCatFromCat = catList;
        List<? super Cat> superCatFromCat = catList;

        List<? extends Cat> extendsCatFromGarField = garfieldList;
        //编辑出错 只能赋值Cat或Cat父类
//      List<? super Cat> superCatFromGarField = garfieldList;

        //第三段
        //下面三行报错，<? extends T> 都无法进行add操作
//        extendsCatFromCat.add(new Animal());
//        extendsCatFromCat.add(new Cat());
//        extendsCatFromCat.add(new Garfield());

        //下行编译报错，只能添加Cat或Cat子类合集
//      superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfield());

        //第四段
        Object catExtends2 = extendsCatFromCat.get(0);
        Cat catExtends1 = extendsCatFromCat.get(0);
        //下行编辑出错。虽然Cat从集合Garfield赋值而来，但擦除类型后，是不知道的
//      Garfield garfield1 = extendsCatFromGarField.get(0);

    }
}
