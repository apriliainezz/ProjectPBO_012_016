package Controller;

import View.User.ViewHalamanResult;
import Model.Menu.ModelOrder;

public class ControllerResult {

    public static void displayOrderDetails(ViewHalamanResult view, ModelOrder order) {

        int total = Integer.parseInt(order.getTtlharga());
        view.getOutputtotal5().setText("Rp " + order.getTtlharga());

        if (order.getSize().equals("Large")) {
            view.getOutputtotal6().setText("Rp 5000");
            total += 5000;
        }
        if (!order.getDairy().isEmpty()) {
            view.getOutputtotal7().setText("Rp 5000");
            total += 5000;

        }
        String[] toppingsArray = order.getTopping().split(",");
        int count = toppingsArray.length;
        if (count != 0) {
            int topp = count * 4000;
            view.getOutputtotal8().setText("Rp " + topp);
            total += topp;
        }
        int tax = (int) (0.15 * total);
        total += tax;
        view.getOutputtotal9().setText("Rp " + tax);

        String hargaString = String.valueOf(total);

        view.getOutputMenu().setText(order.getMenu());
        view.getOutputSize().setText(order.getSize());
        view.getOutputHotIce().setText(order.getHot_ice());
        view.getOutputSweetness().setText(order.getSweetness());
        view.getOutputDairy().setText(order.getDairy());
        view.getjLabel11().setText(order.getTopping());
        view.getOutputNote().setText(order.getNote());
        view.getOutputtotal11().setText("Rp " + hargaString);
        view.getOutputTax().setText("15%");
    }

    // Additional methods for handling specific interactions within the result view can be added here.
}
