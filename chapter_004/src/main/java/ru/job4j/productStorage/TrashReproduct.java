package ru.job4j.productStorage;

public class TrashReproduct extends Reproduct {

   /* public TrashReproduct(Actions reproductAction) {
        super(reproductAction);
    }
*/
    @Override
    public boolean accept(Food food) {
        if (food.canReproduct) {
            return true;
        }
        return false;
    }

    @Override
    public void add(Food food) {
        if (accept(food)) {
            System.out.println("Отправлено на переработку.");
        }
    }


}
