# 2018 — Computer Science

> *Algorithms, recursion, data structures, and real-world problem solving — a year of serious Computer Science.*
> — Fraizer Nxumalo (silentcodeza)

---

## 📖 About

This repository contains all programs completed during the **2018 academic year** as part of a **Computer Science** programme. The work spans classic algorithms, advanced data structures, string processing, recursion, and a real-world Python project — representing one of the most technically rich years in this CS journey.

Key highlights include a fully-documented **Merge Sort**, a recursive **Tower of Hanoi**, an **anagram finder** that processes a million-word corpus, a **South African ID number validator**, and multiple linked list and stack implementations with testers.

---

## 🗂️ Repository Structure

```
2018/
├── MergeSort.java              ← Divide-and-conquer merge sort with step tracing
├── TowerOfHanoi2.java          ← Recursive Tower of Hanoi (5 disks, A→C via B)
├── anagrams.java               ← Anagram finder using Hashtable + HashMap on corpus
├── ID Number Project.py        ← South African ID number validator (Luhn algorithm)
├── Coordinate.java             ← 2D coordinate class (carried from 2015)
├── Matcher.java                ← Fingerprint matching system (carried from 2015)
├── LinkedListInteger.java      ← Linked list of integers
├── LinkedStackInteger.java     ← Stack implementation backed by linked list
├── SLinkedList1.java           ← Singly linked list implementation
├── SLinkedList1Tester1.java    ← Test harness 1 for SLinkedList1
├── SLinkedList1Tester2.java    ← Test harness 2 for SLinkedList1
├── SLinkedListInteger.java     ← Singly linked list specialised for integers
├── SNodeInteger.java           ← Node class for integer linked list
├── TestIntegers.java           ← Integer data structure tests
├── MatchParenthesis1.java      ← Parenthesis matching (stack-based) — v1
├── MatchParenthesis2.java      ← Parenthesis matching (stack-based) — v2
├── writingSum.java             ← Summation writing program
└── LICENSE                     ← MIT License
```

---

## 💻 Languages Used

| Language | Usage |
|----------|-------|
| **Java** | 96.9% — Algorithms, data structures, string processing |
| **Python** | 3.1% — South African ID number validator project |

---

## 🔬 Program Highlights

---

### 🔀 MergeSort.java — Divide & Conquer Sorting
**File:** `MergeSort.java` · 114 lines

A fully-commented, step-tracing implementation of the **Merge Sort** algorithm — one of the most important divide-and-conquer algorithms in computer science with O(n log n) time complexity.

**How it works:**
1. Splits the array in half recursively until single elements remain
2. Merges pairs of sorted halves back together in order
3. Prints each divide and merge step so the process is fully visible

```java
public static void sort(int[] a) {
    if (a.length >= 2) {
        int halfLength = a.length / 2;
        int[] firstHalf = new int[halfLength];
        int[] lastHalf  = new int[a.length - halfLength];
        divide(a, firstHalf, lastHalf);
        sort(firstHalf);   // recursive sort left half
        sort(lastHalf);    // recursive sort right half
        merge(a, firstHalf, lastHalf);  // merge sorted halves
    }
}
```

**Sample output:**
```
Dividing array
firstHalf: 5,2    secondHalf: 8,1
First sort first half
...
now to merge the two arrays
firstHalf: 2,5    secondHalf: 1,8
```

---

### 🗼 TowerOfHanoi2.java — Recursive Tower of Hanoi
**File:** `TowerOfHanoi2.java` · 54 lines

A recursive solution to the classic **Tower of Hanoi** puzzle — moving 5 disks from rod A to rod C using rod B as temporary storage, with step-by-step explanation output.

```java
/*
 * A tower of 5 disks must be moved from rod A to rod C
 * using B as a spare or temporary storage space
 */
public void moveTowers(int n, char A, char B, char C) {
    noOfMoves++;
    if (n == 1)
        System.out.println("Move a disk from rod " + A + " to rod " + C);
    else {
        moveTowers(n-1, A, C, B);  // move n-1 disks out of the way
        System.out.println("Move a disk from rod " + A + " to rod " + B);
        moveTowers(n-1, B, A, C);  // move n-1 disks to destination
    }
}
```

**Output includes:**
```
The task is to move 5 disks from rod A to C using B as spare storage space
subtask is to move 4 disks from rod A to B using C as spare storage space
  Move a disk from rod A to rod C
...
Number of moves to move tower: 16
```

> The minimum number of moves for n disks is **2ⁿ − 1**, so 5 disks requires **31 moves**.

---

### 🔤 anagrams.java — Corpus Anagram Finder
**File:** `anagrams.java` · 83 lines

A sophisticated anagram finder that reads a **million-word corpus** (`data.ulysses` — from James Joyce's *Ulysses*) and identifies all anagram groups using `Hashtable` and `HashMap`.

**Algorithm:**
1. Reads every word from the file and cleans it with regex (`[^A-Za-z']`)
2. Alphabetically sorts each word's characters as a key
3. Groups words with identical sorted keys in a `HashMap<String, ArrayList<String>>`
4. Uses a `Hashtable` to track word frequency
5. Prints all anagram groups sorted alphabetically

```java
String alphaWord = Sort(wordArray[k]);  // e.g. "listen" → "eilnst"
// Same sorted key = anagram group
hashtable2.put(alphaWord, currList);    // group words by sorted key
```

**Output format:**
```
{"aelrt" : [later, alter, ratel]}
{"aenst" : [antes, etnas, nates]}
```

> The implementation found exactly **1,514 anagram groups** in the corpus.

---

### 🇿🇦 ID Number Project.py — SA ID Validator
**File:** `ID Number Project.py` · 46 lines

A Python project that validates **South African Identity Numbers** using a checksum algorithm similar to the Luhn algorithm — directly relevant to real-world South African software development.

**How it works:**
1. Prompts the user for a 13-digit SA ID number
2. Validates that the input is exactly 13 digits, looping until correct
3. Sums all odd-position digits (step A)
4. Concatenates all even-position digits, doubles the result (step B)
5. Sums the digits of that doubled value (step C)
6. Checks if `10 - ((A + C) % 10)` equals the 13th check digit

```python
num = input("enter your id number please: ")
while len(num) > 13 or len(num) < 13:
    num = input("the length of that ID number is wrong...")

# Odd positions sum
for index in range(0, 11, 2):
    A = prev_number + int(num[index])

# Even positions doubled
for index in range(1, 12, 2):
    B = prev_string + str(num[index])
x = 2 * int(B)

if (10 - (D % 10)) == int(num[12]):
    print("This is a Valid South African ID number")
else:
    print("This is not a Valid South African ID number")
```

---

### 🔗 Linked List & Stack Implementations

**Files:** `LinkedListInteger.java`, `SLinkedList1.java`, `SLinkedListInteger.java`, `SNodeInteger.java`, `LinkedStackInteger.java`

A complete set of integer-specific data structure implementations:

| File | Structure | Description |
|------|-----------|-------------|
| `SNodeInteger.java` | Node | Single node holding an integer + next pointer |
| `SLinkedListInteger.java` | Singly Linked List | Integer-typed singly linked list |
| `LinkedListInteger.java` | Linked List | General integer linked list |
| `LinkedStackInteger.java` | Stack | LIFO stack backed by a linked list |
| `SLinkedList1.java` | Singly Linked List | Variant singly linked list implementation |

---

### 🧪 Testers
**Files:** `SLinkedList1Tester1.java`, `SLinkedList1Tester2.java`, `TestIntegers.java`

Dedicated test programs that verify the correctness of the linked list and integer data structure implementations — demonstrating a proper test-driven approach to validating code behaviour.

---

### ⚖️ Parenthesis Matching
**Files:** `MatchParenthesis1.java`, `MatchParenthesis2.java`

Two versions of a classic stack-based algorithm that checks whether brackets and parentheses in an expression are correctly matched — a fundamental application of the Stack data structure used in compilers and syntax validators.

---

### 📐 Coordinate.java & Matcher.java
**Files:** `Coordinate.java`, `Matcher.java`

Continued from the 2015 biometric fingerprint matching project — the `Coordinate` class (2D geometric operations, Euclidean distance, file reading) and the `Matcher` system (fingerprint comparison via distance arrays) are retained and refined for further study.

---

## 📚 Topics Covered

| Topic | Files |
|-------|-------|
| **Divide & Conquer** | `MergeSort.java` |
| **Recursion** | `TowerOfHanoi2.java`, `MergeSort.java` |
| **Hashing & Maps** | `anagrams.java` — `Hashtable`, `HashMap` |
| **String Processing** | `anagrams.java` — regex, sorting, grouping |
| **File I/O** | `anagrams.java` — reading million-word corpus |
| **Python & Validation** | `ID Number Project.py` — Luhn-style checksum |
| **Linked Lists** | `SLinkedList1.java`, `LinkedListInteger.java` |
| **Stacks** | `LinkedStackInteger.java`, `MatchParenthesis1/2.java` |
| **Geometry** | `Coordinate.java` — Euclidean distance |
| **Biometrics** | `Matcher.java` — fingerprint identification |
| **Testing** | `SLinkedList1Tester1/2.java`, `TestIntegers.java` |

---

## 🚀 Getting Started

### Prerequisites
- **Java JDK 8+** for `.java` files
- **Python 3.x** for the ID Number project
- IDE: **IntelliJ IDEA**, **Eclipse**, or **NetBeans**

### Running MergeSort

```bash
git clone https://github.com/silentcodeza/2018.git
cd 2018
javac MergeSort.java
java MergeSort
```

### Running Tower of Hanoi

```bash
javac TowerOfHanoi2.java
java TowerOfHanoi2
```

### Running the Anagram Finder

```bash
# Requires data.ulysses in the same directory
javac anagrams.java
java anagrams
```

### Running the SA ID Validator

```bash
python3 "ID Number Project.py"
# Enter a 13-digit South African ID number when prompted
```

---

## 👨‍💻 Author

**Fraizer Nxumalo**
- GitHub: [@silentcodeza](https://github.com/silentcodeza)
- Year: 2018 — Computer Science

---

## 🔗 The Full CS Journey

| Year | Repository | Key Focus |
|------|-----------|-----------|
| **2013** | [silentcodeza/2013](https://github.com/silentcodeza/2013) | Java fundamentals, factorial, shuffle, merge sort |
| **2014** | [silentcodeza/2014](https://github.com/silentcodeza/2014) | First year CS, architecture, unit exercises |
| **2015** | [silentcodeza/2015](https://github.com/silentcodeza/2015) | Data structures, queues, fingerprint matching |
| **2016** | [silentcodeza/2016](https://github.com/silentcodeza/2016) | GUI (JFrames), Sieve of Eratosthenes, HTML, Python |
| **2017** | [silentcodeza/2017](https://github.com/silentcodeza/2017) | Advanced Java, structured coursework |
| **2018** | [silentcodeza/2018](https://github.com/silentcodeza/2018) | Recursion, hashing, sorting, SA ID validator ← *You are here* |

---

## 📝 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

---

## 🎓 Note

2018 represents a mature, confident year of Computer Science work. From recursive algorithms to real-world South African identity validation, the programs here demonstrate a developer who can think computationally, work across multiple languages, and tackle problems of genuine complexity. The anagram finder alone — processing over a million words from a literary corpus — is a standout achievement.

> *"Simplicity is the soul of efficiency."* — Austin Freeman
