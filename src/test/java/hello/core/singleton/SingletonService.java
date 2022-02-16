package hello.core.singleton;

public class SingletonService {

    // static 영역에 객체를 딱 1 개만 생성해둠.
    private static final SingletonService instance = new SingletonService();

    // public 으로 열어서 객체 인스턴스가 필요하면 이 static method 를 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }
    // 생성자를 private 으로 선언해서, 외부에서 마음대로 new 키워드로 객체 생성하지 못하도록 막음.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
