package me.whiteship.chapter04.item18.callback;

public class Service {

    public void run(FunctionToCall functionToCall) {
        System.out.println("뭐 좀 하다가...");
        functionToCall.call();
    }

    public static void main(String[] args) {
        Service service = new Service();
        BobFunction bobFunction = new BobFunction(service);
//        bobFunction.run();
        /**
         * 3. 의도한 추가기능이 동작하지 않음
         * -> 래퍼 클래스를 만들어서 사용해도 결국 콜백함수 역할로 전달되는 객체는 BobFunction(this)이기 때문에
         */
        BobFunctionWrapper bobFunctionWrapper = new BobFunctionWrapper(bobFunction);
        bobFunctionWrapper.run();
    }
}
