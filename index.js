const { Print, Exit, StringBuilder, IsLeapYear } = require("./util");
const readline = require("readline").createInterface({
	input: process.stdin,
	output: process.stdout
});
const {
	bold, blue, reset,
	yellow, green
} = require("colorette");

/**
	* @param {number[]} array
	* @param {number} value
	* @returns {boolean}
	*/
const ArrayIncludes = (array, value) => {
	for (let i = 0; i < array.length; i++) {
		if (array[i] == value) {
			return true;
		}
	}

	return false;
};

/**
	* @typedef {Object} CalculatedValues
	* @property {number} angel
	* @property {number} pre_angel
	* @property {string} date
	*/

/**
	* @param {number} day
	* @returns {string}
	*/
const CheckDay = (day) => {
	/** @type {string} */
	let str;
	let day_str = day.toString();

	if ((day == 1) || (day == 21) || (day == 31)) {
		str = day_str + "st";
	} else if ((day == 2) || (day == 22)) {
		str = day_str + "nd";
	} else if ((day == 3) || (day == 23)) {
		str = day_str + "rd";
	} else {
		str = day_str + "th";
	}

	return str;
};

/**
	* @param {number} year
	* @param {number} month
	* @param {number} day
	* @returns {CalculatedValues}
	*/
const Calculate = (year, month, day) => {
	let cap = DayCap(month, year);
	/** @type {number} */
	let ii;
	let date_str = StringBuilder("");

	if (MonthCap(year, month, day, cap)) {
		let CalculatedMonth = CalcDayOrMonth(month);
		let CalculatedDay = CalcDayOrMonth(day);
		let CalculatedYear = CalcYear(year);
		let Calculated = CalculatedDay + CalculatedMonth + CalculatedYear;

		ii = Calculated;
	}

	date_str.append("the ");
	date_str.append(CheckDay(day));
	date_str.append(" of ");
	date_str.append(IdentifyMonthText(month).original);
	date_str.append(" ");
	date_str.append(IntToString(year));

	return {
		angel: CalculateAngel(ii),
		pre_angel: ii,
		date: date_str.toString()
	};
};

/**
	* @param {string} str
	*/
const StringToInt = (str) => {
	const numb = Number(str);

	if (numb.toString() == "NaN") {
		return 0;
	} else {
		return numb;
	}
};

/**
	* @param {number} int
	* @returns {string}
	*/
const IntToString = (int) => {
	return String(int);
};

/**
	* @param {number} month
	* @returns {number}
	*/
const MonthLength = (month) => {
	let once = [1, 2, 3, 4, 5, 6, 7, 8, 9];
	let twice = [10, 11, 12];
	/** @type {number} */
	let res;

	if (ArrayIncludes(once, month)) {
		res = 1;
	} else if (ArrayIncludes(twice, month)) {
		res = 2;
	}

	return res;
};

/**
	* @param {number} value 
	*/
const CalcDayOrMonth = (value) => {
	let val = IntToString(value);
	/** @type {number} */
	let ii;

	if (val.length == 1) {
		ii = StringToInt(val[0]);
	} else {
		ii = StringToInt(val[0]) + StringToInt(val[1]);
	}

	return ii;
};

/**
 * @param {number} year
 * @returns {number}
 */
const CalcYear = (year) => {
	let val = IntToString(year);

	if (val.length !== 4) {
		Print("A valid year must be 4 digits long.");
		Exit("failure");
	} else {
		return StringToInt(val[0]) + StringToInt(val[1]) + StringToInt(val[2]) + StringToInt(val[3]);
	}
};

/**
 * @param {number} day
 * @param {number} month
 * @param {number} year
 */
const DayCap = (month, year) => {
	let monthsThirty = [4, 6, 9, 11];
	let monthsThirtyOne = [1, 3, 5, 7, 8, 10, 12];
	/** @type {number} */
	let res;

	if (ArrayIncludes(monthsThirty, month)) {
		res = 30;
	} else if (ArrayIncludes(monthsThirtyOne, month)) {
		res = 31;
	} else if (month == 2) {
		if (IsLeapYear(year)) {
			res = 29;
		} else {
			res = 28;
		}
	}

	return res;
};

/** 
 * @param {number} year
 * @param {number} month
 * @param {number} day
 * @param {number} capper
 * @returns {boolean} 
 */
const MonthCap = (year, month, day, capper) => {
	const cap = DayCap(month, year);
	if (capper == cap && day > cap) {
		Print(`Month ${IdentifyMonthText(month).original} doesn't have more than ${cap} days.`);
		Exit("failure");
	} else {
		return true;
	}
};

/**
 * @typedef {Object} Months
 * @property {string} original
 * @property {string} short
 */

/**
 * @param {number} month
 * @returns {Months}
 */
const IdentifyMonthText = (month) => {
	let months = [
		{ original: "January", short: "Jan" },
		{ original: "February", short: "Feb" },
		{ original: "March", short: "Mar" },
		{ original: "April", short: "Apr" },
		{ original: "May", short: "May" },
		{ original: "June", short: "Jun" },
		{ original: "July", short: "Jul" },
		{ original: "August", short: "Aug" },
		{ original: "September", short: "Sep" },
		{ original: "October", short: "Oct" },
		{ original: "November", short: "Nov" },
		{ original: "December", short: "Dec" }
	];

	if (month > 12) {
		Print("A valid month must be between 1 and 12.");
		Exit("failure");
	} else {
		return months[month - 1];
	}
};

/**
 * @param {number} angel
 */
const CalculateAngel = (angel) => {
	let val = IntToString(angel);
	/** @type {number} */
	let ii;

	ii = StringToInt(val[0]) + StringToInt(val[1]);

	return ii;
};

const main = () => {
	let day;
	let month;
	let year;

	readline.question("Enter the day of your BIRTHDAY when you were born: ", (_day) => {
		day = StringToInt(_day);
		readline.question("Enter the month of your BIRTHDAY when you were born: ", (_month) => {
			month = StringToInt(_month);
			readline.question("Enter the year of your BIRTHDAY when you were born: ", (_year) => {
				year = StringToInt(_year);

				let angelNumb = Calculate(year, month, day);
				Print([
					``,
					`${bold(blue("Date:"))}${reset(" ")}${angelNumb.date}`,
					`${bold(yellow("Your (PRE) Angel Number is:"))}${reset(" ")}${angelNumb.pre_angel}`,
					`${bold(green("Your Angel Number is:"))}${reset(" ")}${angelNumb.angel}`
				]);
			});
		});
	});
};

main();