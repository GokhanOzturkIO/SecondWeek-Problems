
import java.util.Scanner

fun main(){
    sayHi()
    calculate()


}

private fun sayHi() {
    println("Hesap İşlemlerine Hoşgeldin!")
}

private fun calculate(){
    println("Lütfen ilk sayıyı giriniz:")

    val read = Scanner(System.`in`)
    if(read.hasNextDouble() || read.hasNextInt()) {
        val number1 = read.nextDouble()

        println("Hangi işlemi yapmak istersiniz?(Başlarındaki numarayı yazmanız yeterlidir.)")
        println("1.Toplama\n2.Çıkarma\n3.Çarpma\n4.Bölme")

        if (read.hasNextInt()) {
            val operator = read.nextInt()

            if (operator in 1..4) {
                println("Lütfen ikinci sayıyı giriniz:")
                if(read.hasNextDouble() || read.hasNextInt()) {
                    val number2 = read.nextDouble()
                    add(number1,number2,operator)
                }else{
                    println("Geçersiz bir karakter girdiniz. Lütfen tekrar deneyin...")
                }
            } else {
                println("Listede olmayan bir karakter veya işlem numarası girdiniz. Lütfen tekrar deneyin...")
            }

        } else {
            println("Geçersiz karakter girdiniz. Lütfen tekrar deneyin...")
        }
    }
    else{
        read.next()
        println("Yanlış bir değer girdiniz. Lütfen tekrar deneyin...")
    }

    println("Başka bir işlem yapmak ister misiniz ? (Y/N)")
    devamKe()
}
private fun devamKe(){

    val tryy=Scanner(System.`in`).nextLine()
    if(tryy == "Y" || tryy =="y" || tryy=="Yes" || tryy =="YES" || tryy=="yes"){
        calculate()
    }else{
        println("Program Sonlandırılıyor...GoodBye!")
    }
}

private fun add(number1: Double,number2:Double,operator:Int) {

    if(operator ==1){
        println("Sayıların toplamı: ${number1+number2}")
    }else if(operator ==2){
        println("Sayıların farkı: ${number1-number2}")
    }else if(operator ==3){
        println("Sayıların çarpımı: ${number1*number2}")

    }else if(operator ==4){
        if(number2!=0.0){
            println("Sayıların bölümü: ${number1/number2}")
        }
        else{
            println("Bir sayının 0 da bölümünün sonucu tanımsızdır.")
        }
    }
}
