package ru.netology

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter


fun main() {
    val checkDate = LocalDate.now()
    val checkTime = LocalTime.now() // обойти Т символ - разбил на две части дату и время
    val nowDate = (LocalDate.now().toString())
    val nowTime = (LocalTime.now().toString())
    val lastEnter = "03.05.2024 22:05:31"
    val dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
    val lastEnterParse = LocalDateTime.parse(lastEnter, dateFormat)
    val yearLastEnter = lastEnterParse.year
    val monthLastEnter = lastEnterParse.month
    val dayLastEnter = lastEnterParse.dayOfMonth
    val hourLastEnter = lastEnterParse.hour
    val minuteLastEnter = lastEnterParse.minute
    val secondLastEnter = lastEnterParse.second


    val difDays = checkDate.dayOfMonth - dayLastEnter // использую другую формулу, чтобы не было ошибки с текущей датой
    println(difDays) // для проверки разницы дней
    val difHours = (checkTime.minusHours((24-(24-hourLastEnter)).toLong())).hour
    println(difHours) // для проверки разницы часов
    val difMinutes = (checkTime.minusMinutes((60-(60-minuteLastEnter)).toLong())).minute
    println(difMinutes) // для проверки разницы минут
    val difSeconds = (checkTime.minusSeconds((60-(60-secondLastEnter)).toLong())).second
    println(difSeconds) // для проверки разницы секунд, хотя я их практически не использую нигде


    val transferDays = difDays.toString() // для передачи в другую функцию, мне нужен и String и Long/Int.
    val transferHours = difHours.toString()
    val transferMinutes = difMinutes.toString()
    val transferSeconds = difSeconds.toString()
    val result = agoToText(transferDays,transferHours, transferMinutes, transferSeconds)
}

fun agoToText(differenceDays : String, differenceHours : String, differenceMinutes: String, differenceSeconds: String) {
    val differenceDaysL = differenceDays.toInt() // нужно одновременно и String (текст) и Long/int (число) для сравнений
    val differenceHoursL = differenceHours.toInt()
    val differenceMinutesI = differenceMinutes.toInt()
    val firstCharHour = '1'
    val secondCharHour = '2'
    val thirdCharHour = '3'
    val fourthCharHour = '4'

         when { // проверка по суткам
            differenceDaysL >= 3 -> println("Был давно")
            differenceDaysL >= 2 &&  differenceDaysL < 3-> println("Был позавчера")
            differenceDaysL >= 1 && differenceDaysL < 2 && differenceHoursL == 24-> println("Был вчера")

            differenceDaysL <= 1 && differenceHoursL < 24-> when { // проверка по часам

                differenceHoursL in 5..20 -> println("Был " + differenceHours + " часов назад")
                differenceHoursL < 24 && differenceHoursL > 1 && differenceHours.length > 1 &&
                        differenceHours[differenceHours.length - 1] == firstCharHour -> println("Был " + differenceHours + " час назад")

                differenceHoursL == 1 -> println("Был " + differenceHours + " час назад")
                differenceHoursL in 2..4-> println("Был " + differenceHours + " часа назад")

                differenceHoursL < 24 && differenceHoursL > 1 && differenceHours.length > 1 &&
                        differenceHours[differenceHours.length - 1] == secondCharHour -> println("Был " + differenceHours + " часа назад")

                differenceHoursL < 24 && differenceHoursL > 1 && differenceHours.length > 1 &&
                        differenceHours[differenceHours.length - 1] == thirdCharHour -> println("Был " + differenceHours + " часа назад")

                differenceHoursL < 24 && differenceHoursL > 1 && differenceHours.length > 1 &&
                        differenceHours[differenceHours.length - 1] == fourthCharHour -> println("Был " + differenceHours + " часа назад")

                differenceDaysL < 1 && differenceHoursL < 1 -> when { // проверка по минутам

                    differenceMinutesI < 1 -> println("Был только что")
                    differenceMinutesI == 1 -> println("Был " + differenceMinutes + " минуту назад")
                    differenceMinutesI in 2..4 -> println("Был " + differenceMinutes + " минуты назад")
                    differenceMinutesI < 60 && differenceMinutesI > 1 && differenceMinutes.length > 1 && differenceMinutes[differenceMinutes.length - 1] == firstCharHour
                            && differenceMinutesI != 11 -> println("Был " + differenceMinutes + " минуту назад")

                    differenceMinutesI < 60 && differenceMinutes.length > 1 && differenceMinutes[differenceMinutes.length - 1] == secondCharHour
                            && differenceMinutesI != 12 -> println("Был " + differenceMinutes + " минуты назад")

                    differenceMinutesI < 60 && differenceMinutes.length > 1 && differenceMinutes[differenceMinutes.length - 1] == thirdCharHour
                            && differenceMinutesI != 12 -> println("Был " + differenceMinutes + " минуты назад")

                    differenceMinutesI < 60 && differenceMinutes.length > 1 && differenceMinutes[differenceMinutes.length - 1] == fourthCharHour
                            && differenceMinutesI != 14 -> println("Был " + differenceMinutes + " минуты назад")

                    else -> println("Был " + differenceMinutes + " минут назад")
                }
            }

        }
    }







