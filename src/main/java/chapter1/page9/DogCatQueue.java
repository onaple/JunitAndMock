package chapter1.page9;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private Long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0L;
    }

    public void add(Pet pet){
        if (pet.getType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, count++ ));
        } else if (pet.getType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("err, pet is not dog or cat");
        }
    }

    public Pet pollAll(){
        if (!this.catQ.isEmpty() && !this.dogQ.isEmpty()){
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    public Dog pollDog() {
        if (!dogQ.isEmpty()){
            return (Dog)dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public Cat pollCat() {
        if (!catQ.isEmpty()){
            return (Cat) catQ.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty!");
        }
    }

    public boolean isEmpty(){
        return catQ.isEmpty() && dogQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return catQ.isEmpty();
    }
}
