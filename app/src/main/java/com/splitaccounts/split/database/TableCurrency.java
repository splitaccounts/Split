package com.splitaccounts.split.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gaellecoz on 13.11.2015.
 */
public class TableCurrency  extends AbstractSplitDbTable {
        public static final int PROVIDER = 100;
        public static final int PROVIDER_ID = 110;
        public static final String TABLE_NAME = "currency";
        public static final String COLUMN_ISO_CODE = "iso_code";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SYMBOL = "symbol";
        public static final String COLUMN_COUNTRY = "country";
        public static final String COLUMN_USAGE_COUNT = "usage_count";
        private String[] SQL_CREATE = {
                SplitDbContractV1.CREATE + TABLE_NAME + " (" +
                        SplitDbContractV1.ID_PRIMARY_KEY + SplitDbContractV1.SEP_COMMA +
                        COLUMN_ISO_CODE + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                        COLUMN_NAME + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                        COLUMN_SYMBOL + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                        COLUMN_COUNTRY + SplitDbContractV1.TYPE_TEXT + SplitDbContractV1.NOT_NULL + SplitDbContractV1.SEP_COMMA +
                        COLUMN_USAGE_COUNT + SplitDbContractV1.TYPE_INTEGER + SplitDbContractV1.NOT_NULL + SplitDbContractV1.DEFAULT_0 + SplitDbContractV1.SEP_COMMA +
                        SplitDbContractV1.CONSTRAINT_UNIQUE_ID + SplitDbContractV1.SEP_COMMA +
                        SplitDbContractV1.getConstraintUnique(COLUMN_ISO_CODE) +
                        ");",
                SplitDbContractV1.getIndexUnique(TABLE_NAME, _ID),
        };

        private String[] SQL_DROP = {
                SplitDbContractV1.getIndexDrop(TABLE_NAME, _ID),
                SplitDbContractV1.getTableDrop(TABLE_NAME)
        };

        private static final String[][] BASE_VALUES = {
                {"boolean", "display_help", "false"},
                {"boolean", "activate_history", "false"},
                {"boolean", "display_external_tool_error", "false"}
        };

        public String getTableName() {
                return TABLE_NAME;
        }

        public String[] getSqlCreate() {
                return SQL_CREATE;
        }

        public String[] getSqlDrop() {
                return SQL_DROP;
        }

        public String[] getBaseValues() {
                String[] res = new String[BASE_VALUES.length];
                for (int i = 0; i < BASE_VALUES.length; i++) {
                        res[i] = BASE_VALUES[i][1];
                }
                return res;
        }

        public List<String> getBaseValuesInsert() {
                // TODO: properly init BASE_VALUES
                int count = BASE_VALUES.length;
                List<String> queries = new ArrayList<>(Arrays.asList(CURRENCY_INSERT_QUERY));

                queries.add(SplitDbContractV1.getUpdateSequenceQuery(TABLE_NAME, count));

                return queries;
        }

    public static final String[] CURRENCY_INSERT_QUERY = {
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (1, 'AED', 'United Arab Emirates dirham', 'د.إ', 'United Arab Emirates');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (2, 'AFN', 'Afghan afghani', '؋', 'Afghanistan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (3, 'ALL', 'Albanian lek', 'L', 'Albania');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (4, 'AMD', 'Armenian dram', 'AMD', 'Armenia');",
            "UPDATE currency SET country = country || ', Nagorno-Karabakh Republic' WHERE _id = '5';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (6, 'ANG', 'Netherlands Antillean guilder', 'ƒ', 'Curaçao');",
            "UPDATE currency SET country = country || ', Sint Maarten' WHERE _id = '7';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (8, 'AOA', 'Angolan kwanza', 'Kz', 'Angola');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (9, 'ARS', 'Argentine peso', '$', 'Argentina');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (10, 'AUD', 'Australian dollar', '$', 'Australia');",
            "UPDATE currency SET country = country || ', Cocos (Keeling) Islands' WHERE _id = '11';",
            "UPDATE currency SET country = country || ', Kiribati' WHERE _id = '12';",
            "UPDATE currency SET country = country || ', Nauru' WHERE _id = '13';",
            "UPDATE currency SET country = country || ', Tuvalu' WHERE _id = '14';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (15, 'AWG', 'Aruban florin', 'ƒ', 'Aruba');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (16, 'AZN', 'Azerbaijani manat', 'AZN', 'Azerbaijan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (17, 'BAM', 'Bosnia and Herzegovina convertible mark', 'KM or КМ[G]', 'Bosnia and Herzegovina');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (18, 'BBD', 'Barbadian dollar', '$', 'Barbados');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (19, 'BDT', 'Bangladeshi taka', '৳', 'Bangladesh');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (20, 'BGN', 'Bulgarian lev', 'лв', 'Bulgaria');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (21, 'BHD', 'Bahraini dinar', '.د.ب', 'Bahrain');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (22, 'BIF', 'Burundian franc', 'Fr', 'Burundi');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (23, 'BMD', 'Bermudian dollar', '$', 'Bermuda');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (24, 'BND', 'Brunei dollar', '$', 'Brunei');",
            "UPDATE currency SET country = country || ', Singapore' WHERE _id = '25';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (26, 'BOB', 'Bolivian boliviano', 'Bs.', 'Bolivia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (27, 'BRL', 'Brazilian real', 'R$', 'Brazil');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (28, 'BSD', 'Bahamian dollar', '$', 'Bahamas, The');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (29, 'BTN', 'Bhutanese ngultrum', 'Nu.', 'Bhutan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (30, 'BWP', 'Botswana pula', 'P', 'Botswana');",
            "UPDATE currency SET country = country || ', Zimbabwe' WHERE _id = '31';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (32, 'BYR', 'Belarusian ruble', 'Br', 'Belarus');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (33, 'BZD', 'Belize dollar', '$', 'Belize');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (34, 'CAD', 'Canadian dollar', '$', 'Canada');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (35, 'CDF', 'Congolese franc', 'Fr', 'Congo, Democratic Republic of the');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (36, 'CHF', 'Swiss franc', 'Fr', 'Liechtenstein');",
            "UPDATE currency SET country = country || ', Switzerland' WHERE _id = '37';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (38, 'CLP', 'Chilean peso', '$', 'Chile');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (39, 'CNY', 'Chinese yuan', '¥ or 元', 'China');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (40, 'COP', 'Colombian peso', '$', 'Colombia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (41, 'CRC', 'Costa Rican colón', '₡', 'Costa Rica');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (42, 'CUC', 'Cuban convertible peso', '$', 'Cuba');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (43, 'CUP', 'Cuban peso', '$', 'Cuba');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (44, 'CVE', 'Cape Verdean escudo', 'Esc or $', 'Cape Verde');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (45, 'CZK', 'Czech koruna', 'Kč', 'Czech Republic');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (46, 'DJF', 'Djiboutian franc', 'Fr', 'Djibouti');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (47, 'DKK', 'Danish krone', 'kr', 'Denmark');",
            "UPDATE currency SET country = country || ', Faroe Islands' WHERE _id = '48';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (49, 'DOP', 'Dominican peso', '$', 'Dominican Republic');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (50, 'DZD', 'Algerian dinar', 'د.ج', 'Algeria');",
            "UPDATE currency SET country = country || ', Sahrawi Republic[M]' WHERE _id = '51';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (52, 'EGP', 'Egyptian pound', '£ or ج.م', 'Egypt');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (53, 'ERN', 'Eritrean nakfa', 'Nfk', 'Eritrea');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (54, 'ETB', 'Ethiopian birr', 'Br', 'Ethiopia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (55, 'EUR', 'Euro', '€', 'Akrotiri and Dhekelia');",
            "UPDATE currency SET country = country || ', Andorra' WHERE _id = '56';",
            "UPDATE currency SET country = country || ', Austria' WHERE _id = '57';",
            "UPDATE currency SET country = country || ', Belgium' WHERE _id = '58';",
            "UPDATE currency SET country = country || ', Cyprus' WHERE _id = '59';",
            "UPDATE currency SET country = country || ', Estonia' WHERE _id = '60';",
            "UPDATE currency SET country = country || ', Finland' WHERE _id = '61';",
            "UPDATE currency SET country = country || ', France' WHERE _id = '62';",
            "UPDATE currency SET country = country || ', Germany' WHERE _id = '63';",
            "UPDATE currency SET country = country || ', Greece' WHERE _id = '64';",
            "UPDATE currency SET country = country || ', Ireland' WHERE _id = '65';",
            "UPDATE currency SET country = country || ', Italy' WHERE _id = '66';",
            "UPDATE currency SET country = country || ', Kosovo' WHERE _id = '67';",
            "UPDATE currency SET country = country || ', Latvia' WHERE _id = '68';",
            "UPDATE currency SET country = country || ', Lithuania' WHERE _id = '69';",
            "UPDATE currency SET country = country || ', Luxembourg' WHERE _id = '70';",
            "UPDATE currency SET country = country || ', Malta' WHERE _id = '71';",
            "UPDATE currency SET country = country || ', Monaco' WHERE _id = '72';",
            "UPDATE currency SET country = country || ', Montenegro' WHERE _id = '73';",
            "UPDATE currency SET country = country || ', Netherlands[L]' WHERE _id = '74';",
            "UPDATE currency SET country = country || ', Portugal' WHERE _id = '75';",
            "UPDATE currency SET country = country || ', San Marino' WHERE _id = '76';",
            "UPDATE currency SET country = country || ', Slovakia' WHERE _id = '77';",
            "UPDATE currency SET country = country || ', Slovenia' WHERE _id = '78';",
            "UPDATE currency SET country = country || ', Spain' WHERE _id = '79';",
            "UPDATE currency SET country = country || ', Vatican City' WHERE _id = '80';",
            "UPDATE currency SET country = country || ', Zimbabwe' WHERE _id = '81';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (82, 'FJD', 'Fijian dollar', '$', 'Fiji');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (83, 'FKP', 'Falkland Islands pound', '£', 'Falkland Islands');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (84, 'GBP', 'British pound[E]', '£', 'Alderney');",
            "UPDATE currency SET country = country || ', Guernsey' WHERE _id = '85';",
            "UPDATE currency SET country = country || ', Isle of Man' WHERE _id = '86';",
            "UPDATE currency SET country = country || ', Jersey' WHERE _id = '87';",
            "UPDATE currency SET country = country || ', South Georgia and the South Sandwich Islands' WHERE _id = '88';",
            "UPDATE currency SET country = country || ', United Kingdom' WHERE _id = '89';",
            "UPDATE currency SET country = country || ', Zimbabwe' WHERE _id = '90';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (91, 'GEL', 'Georgian lari', 'ლ', 'Georgia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (92, 'GGP[F]', 'Guernsey pound', '£', 'Alderney');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (93, 'GHS', 'Ghana cedi', '₵', 'Ghana');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (94, 'GIP', 'Gibraltar pound', '£', 'Gibraltar');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (95, 'GMD', 'Gambian dalasi', 'D', 'Gambia, The');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (96, 'GNF', 'Guinean franc', 'Fr', 'Guinea');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (97, 'GTQ', 'Guatemalan quetzal', 'Q', 'Guatemala');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (98, 'GYD', 'Guyanese dollar', '$', 'Guyana');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (99, 'HKD', 'Hong Kong dollar', '$', 'Hong Kong');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (100, 'HNL', 'Honduran lempira', 'L', 'Honduras');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (101, 'HRK', 'Croatian kuna', 'kn', 'Croatia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (102, 'HTG', 'Haitian gourde', 'G', 'Haiti');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (103, 'HUF', 'Hungarian forint', 'Ft', 'Hungary');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (104, 'IDR', 'Indonesian rupiah', 'Rp', 'Indonesia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (105, 'ILS', 'Israeli new shekel', '₪', 'Israel');",
            "UPDATE currency SET country = country || ', Palestine' WHERE _id = '106';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (107, 'IMP[F]', 'Manx pound', '£', 'Isle of Man');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (108, 'INR', 'Indian rupee', '₹', 'Bhutan');",
            "UPDATE currency SET country = country || ', India' WHERE _id = '109';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (110, 'IQD', 'Iraqi dinar', 'ع.د', 'Iraq');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (111, 'IRR', 'Iranian rial', '﷼', 'Iran');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (112, 'ISK', 'Icelandic króna', 'kr', 'Iceland');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (113, 'JEP[F]', 'Jersey pound', '£', 'Jersey');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (114, 'JMD', 'Jamaican dollar', '$', 'Jamaica');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (115, 'JOD', 'Jordanian dinar', 'د.ا', 'Jordan');",
            "UPDATE currency SET country = country || ', Palestine' WHERE _id = '116';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (117, 'JPY', 'Japanese yen', '¥', 'Japan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (118, 'KES', 'Kenyan shilling', 'Sh', 'Kenya');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (119, 'KGS', 'Kyrgyzstani som', 'лв[K]', 'Kyrgyzstan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (120, 'KHR', 'Cambodian riel', '៛', 'Cambodia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (121, 'KMF', 'Comorian franc', 'Fr', 'Comoros');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (122, 'KPW', 'North Korean won', '₩', 'Korea, North');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (123, 'KRW', 'South Korean won', '₩', 'Korea, South');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (124, 'KWD', 'Kuwaiti dinar', 'د.ك', 'Kuwait');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (125, 'KYD', 'Cayman Islands dollar', '$', 'Cayman Islands');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (126, 'KZT', 'Kazakhstani tenge', 'KZT', 'Kazakhstan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (127, 'LAK', 'Lao kip', '₭', 'Laos');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (128, 'LBP', 'Lebanese pound', 'ل.ل', 'Lebanon');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (129, 'LKR', 'Sri Lankan rupee', 'Rs or රු', 'Sri Lanka');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (130, 'LRD', 'Liberian dollar', '$', 'Liberia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (131, 'LSL', 'Lesotho loti', 'L', 'Lesotho');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (132, 'LYD', 'Libyan dinar', 'ل.د', 'Libya');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (133, 'MAD', 'Moroccan dirham', 'د.م.', 'Morocco');",
            "UPDATE currency SET country = country || ', Sahrawi Republic[M]' WHERE _id = '134';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (135, 'MDL', 'Moldovan leu', 'L', 'Moldova');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (136, 'MGA', 'Malagasy ariary', 'Ar', 'Madagascar');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (137, 'MKD', 'Macedonian denar', 'ден', 'Macedonia, Republic of');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (138, 'MMK', 'Burmese kyat', 'Ks', 'Burma');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (139, 'MNT', 'Mongolian tögrög', '₮', 'Mongolia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (140, 'MOP', 'Macanese pataca', 'P', 'Macau');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (141, 'MRO', 'Mauritanian ouguiya', 'UM', 'Mauritania');",
            "UPDATE currency SET country = country || ', Sahrawi Republic[M]' WHERE _id = '142';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (143, 'MUR', 'Mauritian rupee', '₨', 'Mauritius');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (144, 'MVR', 'Maldivian rufiyaa', '.ރ', 'Maldives');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (145, 'MWK', 'Malawian kwacha', 'MK', 'Malawi');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (146, 'MXN', 'Mexican peso', '$', 'Mexico');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (147, 'MYR', 'Malaysian ringgit', 'RM', 'Malaysia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (148, 'MZN', 'Mozambican metical', 'MT', 'Mozambique');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (149, 'NAD', 'Namibian dollar', '$', 'Namibia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (150, 'NGN', 'Nigerian naira', '₦', 'Nigeria');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (151, 'NIO', 'Nicaraguan córdoba', 'C$', 'Nicaragua');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (152, 'NOK', 'Norwegian krone', 'kr', 'Norway');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (153, 'NPR', 'Nepalese rupee', '₨', 'Nepal');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (154, 'NZD', 'New Zealand dollar', '$', 'Cook Islands');",
            "UPDATE currency SET country = country || ', New Zealand' WHERE _id = '155';",
            "UPDATE currency SET country = country || ', Niue' WHERE _id = '156';",
            "UPDATE currency SET country = country || ', Pitcairn Islands' WHERE _id = '157';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (158, 'OMR', 'Omani rial', 'ر.ع.', 'Oman');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (159, 'PAB', 'Panamanian balboa', 'B/.', 'Panama');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (160, 'PEN', 'Peruvian nuevo sol', 'S/.', 'Peru');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (161, 'PGK', 'Papua New Guinean kina', 'K', 'Papua New Guinea');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (162, 'PHP', 'Philippine peso', '₱', 'Philippines');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (163, 'PKR', 'Pakistani rupee', '₨', 'Pakistan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (164, 'PLN', 'Polish złoty', 'zł', 'Poland');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (165, 'PRB[F]', 'Transnistrian ruble', 'р.', 'Transnistria');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (166, 'PYG', 'Paraguayan guaraní', '₲', 'Paraguay');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (167, 'QAR', 'Qatari riyal', 'ر.ق', 'Qatar');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (168, 'RON', 'Romanian leu', 'lei', 'Romania');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (169, 'RSD', 'Serbian dinar', 'дин. or din.', 'Serbia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (170, 'RUB', 'Russian ruble', 'RUB', 'Abkhazia');",
            "UPDATE currency SET country = country || ', Russia' WHERE _id = '171';",
            "UPDATE currency SET country = country || ', South Ossetia' WHERE _id = '172';",
            "UPDATE currency SET country = country || ', Ukraine' WHERE _id = '173';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (174, 'RWF', 'Rwandan franc', 'Fr', 'Rwanda');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (175, 'SAR', 'Saudi riyal', 'ر.س', 'Saudi Arabia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (176, 'SBD', 'Solomon Islands dollar', '$', 'Solomon Islands');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (177, 'SCR', 'Seychellois rupee', '₨', 'Seychelles');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (178, 'SDG', 'Sudanese pound', 'ج.س.', 'Sudan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (179, 'SEK', 'Swedish krona', 'kr', 'Sweden');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (180, 'SGD', 'Singapore dollar', '$', 'Brunei');",
            "UPDATE currency SET country = country || ', Singapore' WHERE _id = '181';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (182, 'SHP', 'Saint Helena pound', '£', 'United Kingdom Ascension Island');",
            "UPDATE currency SET country = country || ', Saint Helena' WHERE _id = '183';",
            "UPDATE currency SET country = country || ', Tristan da Cunha' WHERE _id = '184';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (185, 'SLL', 'Sierra Leonean leone', 'Le', 'Sierra Leone');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (186, 'SOS', 'Somali shilling', 'Sh', 'Somalia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (187, 'SRD', 'Surinamese dollar', '$', 'Suriname');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (188, 'SSP', 'South Sudanese pound', '£', 'South Sudan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (189, 'STD', 'São Tomé and Príncipe dobra', 'Db', 'São Tomé and Príncipe');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (190, 'SYP', 'Syrian pound', '£ or ل.س', 'Syria');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (191, 'SZL', 'Swazi lilangeni', 'L', 'Swaziland');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (192, 'THB', 'Thai baht', '฿', 'Thailand');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (193, 'TJS', 'Tajikistani somoni', 'ЅМ', 'Tajikistan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (194, 'TMT', 'Turkmenistan manat', 'm', 'Turkmenistan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (195, 'TND', 'Tunisian dinar', 'د.ت', 'Tunisia');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (196, 'TOP', 'Tongan paʻanga[O]', 'T$', 'Tonga');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (197, 'TRY', 'Turkish lira', 'TRY', 'Northern Cyprus');",
            "UPDATE currency SET country = country || ', Turkey' WHERE _id = '198';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (199, 'TTD', 'Trinidad and Tobago dollar', '$', 'Trinidad and Tobago');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (200, 'TWD', 'New Taiwan dollar', '$', 'Taiwan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (201, 'TZS', 'Tanzanian shilling', 'Sh', 'Tanzania');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (202, 'UAH', 'Ukrainian hryvnia', '₴', 'Ukraine');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (203, 'UGX', 'Ugandan shilling', 'Sh', 'Uganda');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (204, 'USD', 'United States dollar', '$', 'Bonaire');",
            "UPDATE currency SET country = country || ', British Indian Ocean Territory' WHERE _id = '205';",
            "UPDATE currency SET country = country || ', British Virgin Islands' WHERE _id = '206';",
            "UPDATE currency SET country = country || ', Cambodia' WHERE _id = '207';",
            "UPDATE currency SET country = country || ', East Timor' WHERE _id = '208';",
            "UPDATE currency SET country = country || ', Ecuador' WHERE _id = '209';",
            "UPDATE currency SET country = country || ', El Salvador' WHERE _id = '210';",
            "UPDATE currency SET country = country || ', Marshall Islands' WHERE _id = '211';",
            "UPDATE currency SET country = country || ', Micronesia' WHERE _id = '212';",
            "UPDATE currency SET country = country || ', Palau' WHERE _id = '213';",
            "UPDATE currency SET country = country || ', Panama' WHERE _id = '214';",
            "UPDATE currency SET country = country || ', Saba' WHERE _id = '215';",
            "UPDATE currency SET country = country || ', Sint Eustatius' WHERE _id = '216';",
            "UPDATE currency SET country = country || ', Turks and Caicos Islands' WHERE _id = '217';",
            "UPDATE currency SET country = country || ', United States' WHERE _id = '218';",
            "UPDATE currency SET country = country || ', Zimbabwe' WHERE _id = '219';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (220, 'UYU', 'Uruguayan peso', '$', 'Uruguay');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (221, 'UZS', 'Uzbekistani som', 'UZS', 'Uzbekistan');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (222, 'VEF', 'Venezuelan bolívar', 'Bs F', 'Venezuela');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (223, 'VND', 'Vietnamese đồng', '₫', 'Vietnam');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (224, 'VUV', 'Vanuatu vatu', 'Vt', 'Vanuatu');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (225, 'WST', 'Samoan tālā', 'T', 'Samoa');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (226, 'XAF', 'Central African CFA franc', 'Fr', 'Cameroon');",
            "UPDATE currency SET country = country || ', Central African Republic' WHERE _id = '227';",
            "UPDATE currency SET country = country || ', Chad' WHERE _id = '228';",
            "UPDATE currency SET country = country || ', Congo, Republic of the' WHERE _id = '229';",
            "UPDATE currency SET country = country || ', Equatorial Guinea' WHERE _id = '230';",
            "UPDATE currency SET country = country || ', Gabon' WHERE _id = '231';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (232, 'XCD', 'East Caribbean dollar', '$', 'Anguilla');",
            "UPDATE currency SET country = country || ', Antigua and Barbuda' WHERE _id = '233';",
            "UPDATE currency SET country = country || ', Dominica' WHERE _id = '234';",
            "UPDATE currency SET country = country || ', Grenada' WHERE _id = '235';",
            "UPDATE currency SET country = country || ', Montserrat' WHERE _id = '236';",
            "UPDATE currency SET country = country || ', Saint Kitts and Nevis' WHERE _id = '237';",
            "UPDATE currency SET country = country || ', Saint Lucia' WHERE _id = '238';",
            "UPDATE currency SET country = country || ', Saint Vincent and the Grenadines' WHERE _id = '239';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (240, 'XOF', 'West African CFA franc', 'Fr', 'Benin');",
            "UPDATE currency SET country = country || ', Burkina Faso' WHERE _id = '241';",
            "UPDATE currency SET country = country || ', Côte d''Ivoire' WHERE _id = '242';",
            "UPDATE currency SET country = country || ', Guinea-Bissau' WHERE _id = '243';",
            "UPDATE currency SET country = country || ', Mali' WHERE _id = '244';",
            "UPDATE currency SET country = country || ', Niger' WHERE _id = '245';",
            "UPDATE currency SET country = country || ', Senegal' WHERE _id = '246';",
            "UPDATE currency SET country = country || ', Togo' WHERE _id = '247';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (248, 'XPF', 'CFP franc', 'Fr', 'French Polynesia');",
            "UPDATE currency SET country = country || ', New Caledonia' WHERE _id = '249';",
            "UPDATE currency SET country = country || ', Wallis and Futuna' WHERE _id = '250';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (251, 'YER', 'Yemeni rial', '﷼', 'Yemen');",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (252, 'ZAR', 'South African rand', 'R', 'Lesotho');",
            "UPDATE currency SET country = country || ', Namibia' WHERE _id = '253';",
            "UPDATE currency SET country = country || ', South Africa' WHERE _id = '254';",
            "UPDATE currency SET country = country || ', Zimbabwe' WHERE _id = '255';",
            "INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (256, 'ZMW', 'Zambian kwacha', 'ZK', 'Zambia');",
    };
}
