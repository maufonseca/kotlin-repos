# GitHub top Kotlin Repositories

Esse app feito em [Kotlin](https://kotlinlang.org/) é uma lista dos top repositórios do GitHub que são desenvolvidos na linguagem Kotlin.

![Landscape](/images/landscape.png) ![Portrait](/images/portrait.png)

## Instruções de compilação

1. Fazer o clone desse repositório
2. Abrir o projeto com o [Android Studio 3+](https://developer.android.com/studio/?hl=pt-br)
3. Sincronizar as bibliotecas utilizadas pelo Gradle
4. Na barra de menús, selecionar Run > Run app (Shift + F10)
5. Selecionar um dispositivo real ou virtual (simulador) conectado ao computador 
6. Apertar OK

## Executando testes
1. No arquivo **ListActivityTest.kt** esncontra-se um **teste instrumentado** gravado com o Espresso que passa pelo fluxo do aplicativo e verifica que não ocorrem crashes.
Ao executar o teste instrumentado é necessário um dispositivo real ou virtual conectado ao computador. O teste está ocorrendo sem crashes.

## Características técnicas
1. [**Clean Architecture**](https://link.medium.com/ZIkR8dmzOT)
1. [**Kotlin 1.3**](https://kotlinlang.org/)
1. Chamada de serviço assíncrona para recuperar o vetor da internet utilizando [**Retrofit 2**](https://square.github.io/retrofit/) e [**RxAndroid 2**](https://github.com/ReactiveX/RxAndroid)
3. Cache de imagens com [Glide](https://github.com/bumptech/glide)
1. Scroll infinito
2. Redirecionamento para o repositório ao clicar no item da lista
1. Swipe to Refresh
4. Tratamento de erros de conexão para o scroll infinito
7. Uso em retrato/paisagem
8. Testes Instrumentados [**Espresso 3**](https://developer.android.com/training/testing/espresso/)
