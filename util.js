/**
    * @param {string} str 
    */
const SB = (str) => {
    let string = str;

    return {
        /** @param {string} str */
        append: (str) => {
            string += str;
        },
        toString: () => {
            return string;
        }
    };
};

module.exports = {
    /**
        * Checks if said year is a leap year
        * @param {number} year
        * @returns {boolean}
        */
    IsLeapYear: (year) => {
        let val = IntToString(year);

        if (val.length !== 4) {
            Print("A valid year must be 4 digits long.");
            Exit("failure");
        } else {
            if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
                return true;
            } else {
                return false;
            }
        }
    },

    /** @param {string|string[]} value */
    Print: (value) => {
        let str = SB("");

        if (Array.isArray(value)) {
            for (let i = 0; i < value.length; i++) {
                str.append(`${value[i]}\n`);
            }
        } else {
            str.append(value);
        }

        process.stdout.write(str.toString());
    },

    StringBuilder: (str) => {
        return SB(str);
    },

    /** @param {"success"|"failure"} status */
    Exit: (status) => {
        if (status == "success") {
            process.exit(0);
        } else {
            process.exit(1);
        }
    },
};
