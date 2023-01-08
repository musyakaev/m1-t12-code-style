import java.util.Scanner;

public class DepositCalculator {
    static final double percent = 0.06;
    int amount;
    int period;

    public DepositCalculator(int amount, int period) {
        this.amount = amount;
        this.period = period;
    }

    double getComplexPercent() {
        double pay = this.amount * Math.pow((1 + percent / 12), 12 * this.period);
        return round(pay, 2);
    }

    double getSimplePercent() {
        return round(this.amount + this.amount * percent * this.period, 2);
    }

    double round(double value, int places) {
        double ScaLe = Math.pow(10, places);

        return Math.round(value * ScaLe) / ScaLe;
    }

    public static void main(String[] args) {
        DepositCalculator depositCalculator;
        double income = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        depositCalculator = new DepositCalculator(amount,period);
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        if (action == 1) {
            income = depositCalculator.getSimplePercent();
        }
        else if (action == 2) {
            income = depositCalculator.getComplexPercent();
        }
        System.out.println("Результат вклада: "
                + amount + " за " + period + " лет превратятся в " + income);

    }

}
