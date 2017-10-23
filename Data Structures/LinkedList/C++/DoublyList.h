
#include <utility>

/*
 * Double linked list implementation with support for range iteration
 *
 * You can use ctrl + f to find parts of the code:
 *      Auxiliary Classes: classes used to sustain the LinkedList Abstract Data Type.
 *      Constructor / Destructor: all the constructors and desctrutors used to maintain scope of the class
 *      Attributes: private attributes from the class
 *      Methods: All the public methods used to access and modify the class
 *      Auxiliary methods: methods used only by the class, not outside
 *
 * Possible improvements:
 *  Use smart pointers insted of raw pointers
 *  Add support for std::move mechanics
 *  Explain the iterator class implementation (I implemented it based on a textbook so there are things i don't understand yet)
 *  Separate implementation from api in header (.h) and source (.cpp) files (ask @imaprincess first)
 *  add exceptions for out-of-bounds iterations
 *
 *  C++ version: C++11
 */

#ifndef DATASTRUCTURES_DOUBLYLIST_H
#define DATASTRUCTURES_DOUBLYLIST_H


    template<typename T>
    class DoublyList {

        // --- Auxiliary Classes ---

    private:

        struct MyNode {
            T content;
            MyNode *next;
            MyNode *previous;

        public:
            explicit MyNode(const T &cont = T {}, MyNode *nex = nullptr, MyNode *prev = nullptr) : content{cont}, next{nex},
                                                                                         previous{prev} {}
        };

        class const_iterator {

        public:
            const_iterator() : current{nullptr} {}

            // Acessor method for seeing the current data on the iterator
            // It will be used in any operation that doesn't assign new values to the data (I think)
            const T &operator*() const {
                return retrieve();
            }

            // Mutator method for the current data on the iterator, will be used when assigning new values
            T &operator*() {
                return retrieve();
            }

            const_iterator &operator++() {
                current = current->next;
                return *this;
            }

            // This implements the it++ version of the iterator
            // because c++ doesn't have ++operator method, so it needs the empty int
            // parameter to differ the methods ++it (above) and it++
            const_iterator &operator++(int) {
                const_iterator old = *this;
                ++(*this);
                return old;
            }

            bool operator==(const const_iterator &rhs) const {
                return current == rhs.current;
            }

            bool operator!=(const const_iterator &rhs) const {
                return !(*this == rhs);
            }

        protected:
            MyNode *current{};

            T &retrieve() const { return current->content; }

            const_iterator(MyNode *p) : current{p} {}

            friend class DoublyList<T>;
        };

        class iterator : public const_iterator {
        public:
            iterator() = default;

            T &operator*() {
                return const_iterator::retrieve();
            }

            const T &operator*() const {
                return const_iterator::operator*();
            }

            iterator &operator++() {
                this->current = this->current->next;
                return *this;
            }

            iterator &operator++(int) {
                iterator old = *this;
                ++(*this);
                return old;
            }

        protected:
            iterator(MyNode *p) : const_iterator{p} {}

            friend class DoublyList<T>;
        };

        // --- Attributes ---

        int theSize;
        MyNode *first;
        MyNode *last;

    public:

        // --- Constructor / Destructor ---

        // default constructor - initializes the sentinels pointing to each other (first <-> last)
        DoublyList() {
            init();
        }

        ~DoublyList() {
            clear();
            delete first;
            delete last;
        }

        // Copy constructor - the push_back method initializes the size of the list
        DoublyList(const DoublyList<T> &rhs) {
            init();
            for (auto &value : rhs) {
                push_back(value);
            }
        }

        // Assignment operator - Works by creating a copy of the right hand side and switching the values from the list
        // to the new ones assigned to it
        DoublyList &operator=(const DoublyList<T> &rhs) {
            DoublyList copy = rhs;
            std::swap(*this, copy);
            return *this;
        }


        // --- Methods ---
        T &front() {
            return *begin();
        }

        const T &front() const {
            return *begin();
        }

        T &back() {
            return *(--end());
        }

        const T &back() const {
            return *(--end());
        }


        iterator begin() {
            return {first->next};
        }

        const_iterator begin() const {
            return {first->next};
        }

        iterator end() {
            return {last};
        }

        const_iterator end() const {
            return {last};
        }

        iterator &insert(iterator it, const T & value) {
            MyNode *p = it.current;
            theSize++;
            p->previous = p->previous->next = new MyNode(value, p, p->previous);
        }


        void push_back(const T &value) {
            insert(last, value);
        }

        void pop_front() {
            erase(begin());
        }

        void pop_back() {
            erase(--end());
        }

        bool empty() {
            return theSize == 0;
        }


        int size() {
            return theSize;
        }

        void clear() {
            while (!empty()) {
                pop_front();
            }
        }

        // this method erases the value in iterator it
        // It needs to change links from the list properly and take care of allocated memory
        // return retval: Necessary for range erases, see method below.
        iterator erase(iterator it) {
            MyNode *p = it.current;
            iterator retVal{p->next};
            p->previous->next = p->next;
            p->next->previous = p->previous;
            delete p;
            theSize--;

            return retVal;
        }

        iterator erase(iterator from, iterator to) {
            for (iterator it = from; it != to;) {
                it = erase(it);
            }

            return to;
        }

        // --- Auxiliary Methods ---

        // Initializes the sentinel nodes as empty nodes
        void init() {
            theSize = 0;
            first = new MyNode;
            last = new MyNode;
            first->next = last;
            last->previous = first;
        }

    };




#endif //DATASTRUCTURES_DOUBLYLIST_H
