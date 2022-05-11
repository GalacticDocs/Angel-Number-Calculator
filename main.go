package main

import (
	"fmt"
	"errors"
	"os"
	"strconv"
	"golang.org/x/exp/utf8string"
)

func ArrayIncludes(array []int, value int) bool {
	for _, loop_value := range array {
		if loop_value == value {
			return true
		}
	}

	return false
}

type CalculatedValues struct{
	angel int;
	pre_angel int;
	date string;
}

func CheckDay(day int) string {
	var str string
	day_str := fmt.Sprint(day)
	
	if day == 1 || day == 21 || day == 31 {
		str = day_str + "st"
	} else if day == 2 || day == 22 {
		str = day_str + "nd"
	} else if day == 3 || day == 23 {
		str = day_str + "rd"
	} else {
		str = day_str + "th"
	}

	return str
}

func Calculate(year int, month int, day int) *CalculatedValues {
	var (
		monthlyThirty 	 []int = []int{4, 6, 8, 10, 12}
		monthlyThirtyOne []int = []int{1, 3, 5, 7, 9, 11}
		dayCap int
		ii int
		date_str string
	)
	
	if ArrayIncludes(monthlyThirty, month) {
		dayCap = 30
	} else if ArrayIncludes(monthlyThirtyOne, month) {
		dayCap = 31
	} else if month == 2 {
		dayCap = 28
	}

	month_err, is_useable := MonthCap(month, day, dayCap)
	if month_err != nil && !is_useable {
		fmt.Println(month_err)
	} else if month_err == nil && is_useable {
		CalculatedMonth := CalcDayOrMonth(month)
		CalculatedDay := CalcDayOrMonth(day)
		CalculatedYear := CalcYear(year)
		Calculated := CalculatedDay + CalculatedMonth + CalculatedYear

		ii = Calculated
	}

	date_str += "the "
	date_str += CheckDay(day)
	date_str += " of "
	date_str += IdentifyMonthText(month).original
	date_str += " "
	date_str += fmt.Sprint(year)

	return &CalculatedValues{
		angel: CalculateAngel(ii),
		pre_angel: ii,
		date: date_str,
	}
}

func StringToInt(s string) int {
	i, err := strconv.Atoi(s)
  
	if err != nil {
		fmt.Println(err)
    os.Exit(2)
  }
  
	return i
}

func MonthLength(month int) int {
	var (
		once = []int{1, 2, 3, 4, 5, 6, 7, 8, 9}
		twice = []int{10, 11, 12}
	)
	var res int

	if ArrayIncludes(once, month) {
		res = 1
	} else if ArrayIncludes(twice, month) {
		res = 2
	}

	return res
}

func CalcDayOrMonth(value int) int {
	val := fmt.Sprint(value)
	var ii int
	
	if len(val) == 1 {
		ii = StringToInt(utf8string.NewString(val).Slice(0, 1))
	} else if len(val) == 2 {
		ii = StringToInt(utf8string.NewString(val).Slice(0, 1)) + StringToInt(utf8string.NewString(val).Slice(1, 2))
	}

	return ii
}

func CalcYear(year int) int {
	val := fmt.Sprint(year)

	return StringToInt(utf8string.NewString(val).Slice(0, 1)) + StringToInt(utf8string.NewString(val).Slice(1, 2)) + StringToInt(utf8string.NewString(val).Slice(2, 3)) + StringToInt(utf8string.NewString(val).Slice(3, 4))
}

func MonthCap(month int, day int, capper int) (error, bool) {
	if capper == 30 && day > 30 {
		return errors.New("Month " + IdentifyMonthText(month).original + " doesn't have more than 30 days"), false
	} else if capper == 31 && day > 31 {
		return errors.New("Month " + IdentifyMonthText(month).original + " doesn't have more than 31 days"), false
	} else if capper == 28 && day > 28 {
		return errors.New("Month " + IdentifyMonthText(month).original + " doesn't have more than 28 days"), false
	} else {
		return nil, true
	}
}

type Months struct{
	short string;
	original string;
}

func IdentifyMonthText(month int) *Months {
	var mon *Months
	
	switch month {
		case 1: mon = &Months{
			short: "Jan",
			original: "January",
		}
		case 2: mon = &Months{
			short: "Feb",
			original: "February",
		}
		case 3: mon = &Months{
			short: "Mar",
			original: "March",
		}
		case 4: mon = &Months{
			short: "Apr",
			original: "April",
		}
		case 5: mon = &Months{
			short: "May",
			original: "May",
		}
		case 6: mon = &Months{
			short: "Jun",
			original: "June",
		}
		case 7: mon = &Months{
			short: "Jul",
			original: "July",
		}
		case 8: mon = &Months{
			short: "Aug",
			original: "August",
		}
		case 9: mon = &Months{
			short: "Sep",
			original: "September",
		}
		case 10: mon = &Months{
			short: "Oct",
			original: "October",
		}
		case 11: mon = &Months{
			short: "Nov",
			original: "November",
		}
		case 12: mon = &Months{
			short: "Dec",
			original: "December",
		}

		default: mon = &Months{
			short: "Jan",
			original: "January",
		}
	}

	return mon
}

func CalculateAngel(angel int) int {
	val := fmt.Sprint(angel)
	var ii int
	
	ii = StringToInt(utf8string.NewString(val).Slice(0, 1)) + StringToInt(utf8string.NewString(val).Slice(1, 2))

	return ii
}

func main() {
	fmt.Print("Enter the day of your BIRTHDAY when you were born: ")

	var day int
	fmt.Scan(&day)

	fmt.Print("Enter the month of your BIRTHDAY when you were born: ")

	var month int
	fmt.Scan(&month)

	fmt.Print("Enter the year of your BIRTHDAY when you were born: ")

	var year int
	fmt.Scan(&year)

	angelNumb := Calculate(year, month, day)
	fmt.Printf("\nDate: %s", angelNumb.date)
	fmt.Printf("\nYour (PRE) Angel Number is: %d", angelNumb.pre_angel)
	fmt.Printf("\nYour Angel Number is: %d", angelNumb.angel)
	fmt.Print("\n")
}
