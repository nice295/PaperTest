Paper Library 테스트
===================
Paper는 빠르고 심플한 데이터 스토리지 안드로이드용 라이브러리이다.
기존적으로 지원하는 SharedPreference나 SQLite를 대신해서 사용할 수 있다.

더 자세한 설명은 이곳에: [https://github.com/pilgr/Paper](https://github.com/pilgr/Paper)


테스트 해보기
--------
라이브러리 가지고 오기
```
compile 'io.paperdb:paperdb:1.5'
```

Paper 초기화

Application나 Activity의 onCreate()에서 아래를 호출한다.
```
Paper.init(context);
```

Save
```
Paper.book().write("city", "Lund"); // Primitive
Paper.book().write("task-queue", queue); // LinkedList
Paper.book().write("countries", countryCodeMap); // HashMap
```

Read
```
String city = Paper.book().read("city");
LinkedList queue = Paper.book().read("task-queue");
HashMap countryCodeMap = Paper.book().read("countries");
```

저장되어 있지 않는 경우를 대비한 default로 읽기
```
String city = Paper.book().read("city", "Kyiv");
LinkedList queue = Paper.book().read("task-queue", new LinkedList());
HashMap countryCodeMap = Paper.book().read("countries", new HashMap());
```

Delete
```
Paper.book().delete("countries");
```

Destroy
```
Paper.book().destroy();
```