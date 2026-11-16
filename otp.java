public class otp {
    public static void main(String[] args) {
        int digits = 5;

        String otpWithRandom = generateOtpUsingRandom(digits);
        String otpWithoutRandom = generateOtpWithoutRandom(digits);

        System.out.println("Digits       : " + digits);
        System.out.println("With Random  : " + otpWithRandom);
        System.out.println("Without Random: " + otpWithoutRandom);
    }

    // Uses java.util.Random to generate an OTP in the given digit length.
    public static String generateOtpUsingRandom(int digits) {
        java.util.Random random = new java.util.Random();
        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits) - 1;
        int otp = random.nextInt(max - min + 1) + min;
        return String.valueOf(otp);
    }

    // Does not use Random or Math.random; builds digits from time-based values.
    public static String generateOtpWithoutRandom(int digits) {
        long seed = System.nanoTime() ^ System.currentTimeMillis() ^ Thread.currentThread().threadId();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < digits; i++) {
            seed = seed * 1103515245L + 12345L;
            int digit = (int) Math.abs((seed / 65536) % 10);
            otp.append(digit);
        }

        return otp.toString();
    }
}