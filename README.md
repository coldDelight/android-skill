# android-skill

```
❓  Android / Kotlin / 프로젝트에 보편적으로 사용하는 기술 모음
```


# :one: Skill
- v1
  - ```clean architecture```
  - ```mvvm```
  - ```navigation component```
  - ```coroutines```
  - ```StateFlow```
  - ```dagger-hilt```
  - ```retrofit```
  - ```glide```
  - ```room```
  - ```data binding```
  - ```base```
  - ```error handling```


# :two: Structure
```
📦 android-skill
 ┣ 📂 app
 ┃ ┗ 📂 base
 ┃ ┃ ┣ 📜 BaseFragment.kt
 ┃ ┃ ┣ 📜 BaseViewModel.kt
 ┃ ┗ 📂 di
 ┃ ┃ ┣ 📜 DataSourceModule.kt
 ┃ ┃ ┣ 📜 LocalDataModule.kt
 ┃ ┃ ┣ 📜 RepositoryModule.kt
 ┃ ┃ ┣ 📜 UseCaseModule.kt
 ┃ ┗ 📜 FetchState.kt
 ┃ ┣ 📂 adapter
 ┃ ┣ 📂 viewModel
 ┣ 📂 data
 ┃ ┗ 📂 local
 ┃ ┃ ┣ 📂 dao
 ┃ ┃ ┣ 📂 entity
 ┃ ┃ ┣ 📜 LocalDatabase.kt
 ┃ ┗ 📂 remote
 ┃ ┃ ┣ 📂 dataSource
 ┃ ┃ ┣ 📂 dataSourceImpl
 ┃ ┃ ┣ 📂 dto
 ┃ ┃ ┣ 📜 NetworkModule.kt
 ┃ ┗ 📂 repositoryImpl
 ┣ 📂 domin
 ┃ ┗ 📂 model
 ┃ ┗ 📂 repository
 ┃ ┗ 📂 usecase
```
