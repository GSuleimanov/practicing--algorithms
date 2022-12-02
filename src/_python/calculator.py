#! /usr/bin/python3

# Writing some python code after a long break was a real pleasure.
# The purpose was to demonstrate the difference between python and java code to my friend.

from enum import Enum


class DigitsType(Enum):
    ROMAN = 1
    ARABIC = 2
    MIXED = 3


class Checks:

    @staticmethod
    def for_expression(inp: list[str]) -> None:
        inp = list(filter(None, inp))
        if len(inp) != 3: raise RuntimeError("Incorrect expression!")
        elif inp[1] not in ('+', '-', '*', '/'): raise RuntimeError('Unsupported operator!')

    @staticmethod
    def for_types(dtype: DigitsType) -> None:
        if dtype == DigitsType.MIXED: raise RuntimeError("Different types!")

    @staticmethod
    def for_correct_roman(a_roman: str, b_roman: str) -> None:
        if any(any(c not in Converter.roman_integer.keys() for c in x) for x in (a_roman, b_roman)):
            raise RuntimeError("Incorrect roman symbols!")

    @staticmethod
    def for_range(a: int, b: int) -> None:
        if not all(x in range(0, 11, 1) for x in (a, b)): raise RuntimeError("Out of range!")

    @staticmethod
    def for_result(dtype: DigitsType, result: int) -> None:
        if dtype == DigitsType.ROMAN and result <= 0: raise RuntimeError("Result is lower than 1!")


class Converter:
    roman_integer: dict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100}
    integers: list[int] = [1, 4, 5, 9, 10, 40, 50, 90, 100]
    romans: list[str] = ['I', 'IV', 'V', 'IX', 'X', 'XL', 'L', 'XC', 'C']

    def __init__(self, input_from_user: str):
        l = input_from_user.split(" ")
        Checks.for_expression(l)
        self.operator = l[1]
        self.digits_type = self._resolve_digits_type(l[0], l[2])
        Checks.for_types(self.digits_type)
        if self.digits_type == DigitsType.ROMAN: Checks.for_correct_roman(l[0], l[2])
        self.a, self.b = self.resolve_to_integer(l[0], l[2])
        Checks.for_range(self.a, self.b)

    @staticmethod
    def _calc_roman_iteration(some_string: str, i: int) -> int:
        cur = Converter.roman_integer.get(some_string[i])
        nxt = Converter.roman_integer.get(some_string[i - 1]) if i > 0 else 0
        return cur - 2*nxt if nxt < cur else cur

    @staticmethod
    def roman_to_int(str_roman: str) -> int:
        return sum(Converter._calc_roman_iteration(str_roman, i) for i in range(len(str_roman)-1, -1, -1))

    @staticmethod
    def int_to_roman(int_arab: int) -> str:
        result = ''
        while int_arab > 0:
            prev_value = next(v for v in reversed(Converter.integers) if v <= int_arab)
            result += Converter.romans[Converter.integers.index(prev_value)]
            int_arab = int_arab - prev_value
        return result

    def _resolve_digits_type(self, a: int, b: int) -> DigitsType:
        if a.isdigit() and b.isdigit(): return DigitsType.ARABIC
        elif a.isalpha() and b.isalpha(): return DigitsType.ROMAN
        else: return DigitsType.MIXED

    def resolve_to_integer(self, a, b) -> list():
        match self.digits_type:
            case DigitsType.ARABIC: return int(a), int(b)
            case DigitsType.ROMAN: return [Converter.roman_to_int(ch) for ch in (a, b)]

    def resolve_result(self, result: int) -> str:
        Checks.for_result(self.digits_type, result)
        match self.digits_type:
            case DigitsType.ARABIC: return str(result)
            case DigitsType.ROMAN: return Converter.int_to_roman(result)


def make_math(a: int, b: int, operator: str) -> int:
    match operator:
        case '+': return a + b
        case '-': return a - b
        case '*': return a * b
        case '/': return int(a / b)


def calc(someString: str) -> str:
    conv = Converter(someString)
    result = make_math(conv.a, conv.b, conv.operator)
    return conv.resolve_result(result)


user_input = input("Enter expression: ")
result = calc(user_input)
print(result)
