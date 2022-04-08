package lambdasExamples;

public class Example1 {
    public static void main(String[] args) {
        int n = 5;
        Human[] humans = new Human[n];


        for (int i =0; i< humans.length;i++){
            humans[i] = new Human();
            System.out.println(humans[i]);
        }
        sort(humans, (human1, human2)->{
            if (human1.getAge()>human2.getAge()){
                return 1;
            }else{
                return -1;
            }
        });
        System.out.println("==========");
        for(int i =0;i< humans.length;i++){
            System.out.println(humans[i]);
        }
        // лям
    }

    private static void sort(Human[] humans, HumanSortStrategy humanSortStrategy){
        for (int i = 0; i < humans.length;i++){
            for (int j = i +1; j< humans.length;j++){
                if (humanSortStrategy.compare(humans[i], humans[j]) == -1){ // задать порядок
                    //swap
                    Human tmpHuman = humans[i];
                    humans[i] = humans[j];
                    humans[j] = tmpHuman;
                }
            }
        }

    }
}

class SortHumanByAge implements HumanSortStrategy{
    @Override
    public int compare(Human human1, Human human2) {
        if (human1.getAge() == human2.getAge()){
            return 0;
        }else if(human1.getAge()>human2.getAge()){
            return -1;
        }else{
            return 1;
        }
    }
}

class SortHumanByCarAmount implements HumanSortStrategy{
    @Override
    public int compare(Human human1, Human human2) {
        if (human1.getAmountOfCars() == human2.getAmountOfCars()){
            return 0;
        }else if(human1.getAmountOfCars()>human2.getAmountOfCars()){
            return -1;
        }else{
            return 1;
        }
    }
}
// функциональный интерфейс т.к. содержит один метод
/*
return 1 human2> human1
0 human1= human2
-1 human1>human2
 */
interface HumanSortStrategy{
    int compare(Human human1, Human human2);
}

class Human{
    private int age;
    private int amountOfCars;

    public Human() {
        this.age = (int) (Math.random()*100 + 10);
        this.amountOfCars = (int) (Math.random()*5 +1);
    }

    public int getAge() {
        return age;
    }

    public int getAmountOfCars() {
        return amountOfCars;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", amountOfCars=" + amountOfCars +
                '}';
    }
}
