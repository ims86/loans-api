package tech.ims.loans_api.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tech.ims.loans_api.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan{
        @Test
        void shouldBeTrueWhenIncomeIsEqual(){
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrLowerThan(5000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThan(){
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrLowerThan(6000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeGreaterThanValue(){
            var customer = CustomerFactory.build(5000.0);

            assertFalse(customer.isIncomeEqualOrLowerThan(3000.0));
        }
    }

    @Nested
    class isIncomeEqualOrGreaterThan{
        @Test
        void shouldBeTrueWhenIncomeIsEqual(){
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrGreaterThan(5000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThan(){
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrGreaterThan(3000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeLowerThanValue(){
            var customer = CustomerFactory.build(5000.0);

            assertFalse(customer.isIncomeEqualOrGreaterThan(6000.0));
        }
    }

    @Nested
    class isIncomeBetween{
        @Test
        void shouldBeTrueWhenIncomeIsBetween(){
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeBetween(3000.0, 7000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualMin(){
            var customer = CustomerFactory.build(3000.0);

            assertTrue(customer.isIncomeBetween(3000.0, 7000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualMax(){
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeBetween(3000.0, 5000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotBetween(){
            var customer = CustomerFactory.build(5000.0);

            assertFalse(customer.isIncomeBetween(3000.0, 4000.0));
        }
    }

    @Nested
    class isAgeLowerThan {
        @Test
        void shouldBeTrueWhenAgeIsLowerThan() {
            var customer = CustomerFactory.build(20);

            assertTrue(customer.isAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsNotLowerThan() {
            var customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(20));
        }

        @Test
        void shouldBeFalseWhenAgeIsEqualToValue() {
            var customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(25));
        }
    }

    @Nested
    class isFromLocation {
        @Test
        void shouldBeTrueWhenLocationIsTheSame() {
            var customer = CustomerFactory.build("SP");

            assertTrue(customer.isFromLocation("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsNotTheSame() {
            var customer = CustomerFactory.build("SP");

            assertFalse(customer.isFromLocation("RS"));
        }
    }
}