package com.safecam.easyquote.util

import android.util.Patterns
import java.util.regex.Pattern

/**
 * Validation functions for input string
 * @author Darien
 */


/**
 * Validate if the string is a valid email
 *
 * @return true if is a valid email
 */
fun String.isValidEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

/**
 * Validate if the string is a valid password
 *
 * must contains one digit from 0-9
 * must contains one lowercase characters
 * must contains one uppercase characters
 * must contains one special symbols in the list "@#$%"
 * length at least 6 characters and maximum of 20
 *
 * @return true if is a valid password
 */
fun String.isValidPassword(): Boolean = Pattern.matches(PASSWORD_PATTERN, this)

/**
 * (?=.*\d)      #   must contains one digit from 0-9
 * (?=.*[a-z])   #   must contains one lowercase characters
 * (?=.*[A-Z])   #   must contains one uppercase characters
 * (?=.*[@#$%])  #   must contains one special symbols in the list "@#$%"
 * .             #   match anything with previous condition checking
 * {6,20}        #   length at least 6 characters and maximum of 20
 */
private const val PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"