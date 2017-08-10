package chapter1.page9;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DogCatQueueTest {
    @Test
    public void testPoll() throws Exception {
        DogCatQueue dogCatQueue = new DogCatQueue();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Cat cat1 = new Cat();

        dogCatQueue.add(dog1);
        dogCatQueue.add(cat1);
        dogCatQueue.add(dog2);

        Assert.assertTrue(dogCatQueue.pollAll().getType() == "dog");
        Assert.assertTrue(dogCatQueue.pollCat().getType() == "cat");
        Assert.assertTrue(dogCatQueue.pollDog().getType() == "dog");

    }

    @Test
    public void testIsEmpty() throws Exception {
        DogCatQueue dogCatQueue = new DogCatQueue();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Cat cat1 = new Cat();
        dogCatQueue.add(dog1);
        dogCatQueue.add(cat1);
        dogCatQueue.add(dog2);
        Assert.assertTrue(!dogCatQueue.isEmpty());
        Assert.assertTrue(!dogCatQueue.isDogQueueEmpty());
        Assert.assertTrue(!dogCatQueue.isCatQueueEmpty());

    }

}