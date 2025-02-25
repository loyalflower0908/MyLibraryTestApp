# MyLibraryTestApp

안드로이드 스튜디오에서 Android Library(SDK) 모듈을 만들어서,

앱 모듈에서 의존성을 추가하고 사용하는 예시 프로젝트입니다.

즉, 라이브러리를 만드는 것에 대한 학습용 예제입니다.

## 특징

- 안드로이드 라이브러리 모듈(mylibrary)에서 작성한 기능 함수를
- 앱 모듈(app)에서 의존성 추가 후 호출.
- Jetpack Compose를 사용하여 라이브러리를 테스트하는 UI를 구성.
- AGP 8.8+(Android Gradle Plugin), Java 17 환경에서 빌드.

## 요구 사항 (Requirements)
- Android Studio (일반적으로 최신 버전 권장)
- JDK 17 이상 (AGP 8.8+에서 필수)
- Gradle 8.x 버전

## 라이브러리 함수 예시
```kotlin
object MyLibraryManager {
    private const val TAG = "MyLibraryManager"

    fun printLog(message: String) {
        Log.d(TAG, "Message from MyLibrary: $message")
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, "MyLibrary says: $message", Toast.LENGTH_SHORT).show()
    }
}
```

## 로컬 AAR 빌드 & 사용
**빌드**
```bash
./gradlew :mylibrary:assembleRelease
```
해당 명령어를 사용해서 이미 AAR을 만들어 놓은 상태.(로컬에서 사용할 때 AAR로 만들어서 사용 가능)
> mylibrary/build/outputs/aar/mylibrary-release.aar

Maven Central, JitPack 등 퍼블릭 저장소 배포는 다음에 제대로된 기능들로 이루어진 라이브러리를 만들어보고 해보려 한다.

&nbsp;

**사용**
- libs 폴더에 AAR 파일 복사
> AAR를 사용할 새 프로젝트(혹은 기존 프로젝트)의 모듈(예: app) 내부에 libs 폴더를 만듭니다.
경로 예: MyOtherProject/app/libs/

- Gradle 설정 (app/build.gradle)
```groovy
dependencies {
    // ...
    implementation files("libs/mylibrary-release.aar")
}
```
> 이렇게 하면, mylibrary-release.aar 안의 클래스나 리소스를 불러올 수 있습니다.

## 알게된 점

### 1. 라이브러리 플러그인 적용

- 기존 com.android.application이 아니라 com.android.library를 써야 함

### 2. 라이브러리에서 defaultConfig 정리

- applicationId 제거
- versionCode, versionName 제거
(라이브러리 모듈에는 불필요)

### 3. 라이브러리 배포

- 라이브러리 모듈을 다른 프로젝트에서 AAR로 추가(로컬)
  Maven/JitPack 등에 배포하여 사용

### 4. AAR 빌드하기

- ./gradlew :mylibrary:assembleRelease
- 결과: mylibrary/build/outputs/aar/*.aar 생성

