<?php

//phpinfo();

$currencies = array(
array('United Arab Emirates','United Arab Emirates dirham','د.إ','AED'),
array('Afghanistan','Afghan afghani','؋','AFN'),
array('Albania','Albanian lek','L','ALL'),
array('Armenia','Armenian dram','AMD','AMD'),
array('Nagorno-Karabakh Republic','Armenian dram','AMD','AMD'),
array('Curaçao','Netherlands Antillean guilder','ƒ','ANG'),
array('Sint Maarten','Netherlands Antillean guilder','ƒ','ANG'),
array('Angola','Angolan kwanza','Kz','AOA'),
array('Argentina','Argentine peso','$','ARS'),
array('Australia','Australian dollar','$','AUD'),
array('Cocos (Keeling) Islands','Australian dollar','$','AUD'),
array('Kiribati','Australian dollar','$','AUD'),
array('Nauru','Australian dollar','$','AUD'),
array('Tuvalu','Australian dollar','$','AUD'),
array('Aruba','Aruban florin','ƒ','AWG'),
array('Azerbaijan','Azerbaijani manat','AZN','AZN'),
array('Bosnia and Herzegovina','Bosnia and Herzegovina convertible mark','KM or КМ[G]','BAM'),
array('Barbados','Barbadian dollar','$','BBD'),
array('Bangladesh','Bangladeshi taka','৳','BDT'),
array('Bulgaria','Bulgarian lev','лв','BGN'),
array('Bahrain','Bahraini dinar','.د.ب','BHD'),
array('Burundi','Burundian franc','Fr','BIF'),
array('Bermuda','Bermudian dollar','$','BMD'),
array('Brunei','Brunei dollar','$','BND'),
array('Singapore','Brunei dollar','$','BND'),
array('Bolivia','Bolivian boliviano','Bs.','BOB'),
array('Brazil','Brazilian real','R$','BRL'),
array('Bahamas, The','Bahamian dollar','$','BSD'),
array('Bhutan','Bhutanese ngultrum','Nu.','BTN'),
array('Botswana','Botswana pula','P','BWP'),
array('Zimbabwe','Botswana pula','P','BWP'),
array('Belarus','Belarusian ruble','Br','BYR'),
array('Belize','Belize dollar','$','BZD'),
array('Canada','Canadian dollar','$','CAD'),
array('Congo, Democratic Republic of the','Congolese franc','Fr','CDF'),
array('Liechtenstein','Swiss franc','Fr','CHF'),
array('Switzerland','Swiss franc','Fr','CHF'),
array('Chile','Chilean peso','$','CLP'),
array('China','Chinese yuan','¥ or 元','CNY'),
array('Colombia','Colombian peso','$','COP'),
array('Costa Rica','Costa Rican colón','₡','CRC'),
array('Cuba','Cuban convertible peso','$','CUC'),
array('Cuba','Cuban peso','$','CUP'),
array('Cape Verde','Cape Verdean escudo','Esc or $','CVE'),
array('Czech Republic','Czech koruna','Kč','CZK'),
array('Djibouti','Djiboutian franc','Fr','DJF'),
array('Denmark','Danish krone','kr','DKK'),
array('Faroe Islands','Danish krone','kr','DKK'),
array('Dominican Republic','Dominican peso','$','DOP'),
array('Algeria','Algerian dinar','د.ج','DZD'),
array('Sahrawi Republic[M]','Algerian dinar','د.ج','DZD'),
array('Egypt','Egyptian pound','£ or ج.م','EGP'),
array('Eritrea','Eritrean nakfa','Nfk','ERN'),
array('Ethiopia','Ethiopian birr','Br','ETB'),
array('Akrotiri and Dhekelia','Euro','€','EUR'),
array('Andorra','Euro','€','EUR'),
array('Austria','Euro','€','EUR'),
array('Belgium','Euro','€','EUR'),
array('Cyprus','Euro','€','EUR'),
array('Estonia','Euro','€','EUR'),
array('Finland','Euro','€','EUR'),
array('France','Euro','€','EUR'),
array('Germany','Euro','€','EUR'),
array('Greece','Euro','€','EUR'),
array('Ireland','Euro','€','EUR'),
array('Italy','Euro','€','EUR'),
array('Kosovo','Euro','€','EUR'),
array('Latvia','Euro','€','EUR'),
array('Lithuania','Euro','€','EUR'),
array('Luxembourg','Euro','€','EUR'),
array('Malta','Euro','€','EUR'),
array('Monaco','Euro','€','EUR'),
array('Montenegro','Euro','€','EUR'),
array('Netherlands[L]','Euro','€','EUR'),
array('Portugal','Euro','€','EUR'),
array('San Marino','Euro','€','EUR'),
array('Slovakia','Euro','€','EUR'),
array('Slovenia','Euro','€','EUR'),
array('Spain','Euro','€','EUR'),
array('Vatican City','Euro','€','EUR'),
array('Zimbabwe','Euro','€','EUR'),
array('Fiji','Fijian dollar','$','FJD'),
array('Falkland Islands','Falkland Islands pound','£','FKP'),
array('Alderney','British pound[E]','£','GBP'),
array('Guernsey','British pound[E]','£','GBP'),
array('Isle of Man','British pound[E]','£','GBP'),
array('Jersey','British pound[E]','£','GBP'),
array('South Georgia and the South Sandwich Islands','British pound','£','GBP'),
array('United Kingdom','British pound[E]','£','GBP'),
array('Zimbabwe','British pound[E]','£','GBP'),
array('Georgia','Georgian lari','ლ','GEL'),
array('Alderney','Guernsey pound','£','GGP[F]'),
array('Ghana','Ghana cedi','₵','GHS'),
array('Gibraltar','Gibraltar pound','£','GIP'),
array('Gambia, The','Gambian dalasi','D','GMD'),
array('Guinea','Guinean franc','Fr','GNF'),
array('Guatemala','Guatemalan quetzal','Q','GTQ'),
array('Guyana','Guyanese dollar','$','GYD'),
array('Hong Kong','Hong Kong dollar','$','HKD'),
array('Honduras','Honduran lempira','L','HNL'),
array('Croatia','Croatian kuna','kn','HRK'),
array('Haiti','Haitian gourde','G','HTG'),
array('Hungary','Hungarian forint','Ft','HUF'),
array('Indonesia','Indonesian rupiah','Rp','IDR'),
array('Israel','Israeli new shekel','₪','ILS'),
array('Palestine','Israeli new shekel','₪','ILS'),
array('Isle of Man','Manx pound','£','IMP[F]'),
array('Bhutan','Indian rupee','₹','INR'),
array('India','Indian rupee','₹','INR'),
array('Iraq','Iraqi dinar','ع.د','IQD'),
array('Iran','Iranian rial','﷼','IRR'),
array('Iceland','Icelandic króna','kr','ISK'),
array('Jersey','Jersey pound','£','JEP[F]'),
array('Jamaica','Jamaican dollar','$','JMD'),
array('Jordan','Jordanian dinar','د.ا','JOD'),
array('Palestine','Jordanian dinar','د.ا','JOD'),
array('Japan','Japanese yen','¥','JPY'),
array('Kenya','Kenyan shilling','Sh','KES'),
array('Kyrgyzstan','Kyrgyzstani som','лв[K]','KGS'),
array('Cambodia','Cambodian riel','៛','KHR'),
array('Comoros','Comorian franc','Fr','KMF'),
array('Korea, North','North Korean won','₩','KPW'),
array('Korea, South','South Korean won','₩','KRW'),
array('Kuwait','Kuwaiti dinar','د.ك','KWD'),
array('Cayman Islands','Cayman Islands dollar','$','KYD'),
array('Kazakhstan','Kazakhstani tenge','KZT','KZT'),
array('Laos','Lao kip','₭','LAK'),
array('Lebanon','Lebanese pound','ل.ل','LBP'),
array('Sri Lanka','Sri Lankan rupee','Rs or රු','LKR'),
array('Liberia','Liberian dollar','$','LRD'),
array('Lesotho','Lesotho loti','L','LSL'),
array('Libya','Libyan dinar','ل.د','LYD'),
array('Morocco','Moroccan dirham','د.م.','MAD'),
array('Sahrawi Republic[M]','Moroccan dirham','د. م.','MAD'),
array('Moldova','Moldovan leu','L','MDL'),
array('Madagascar','Malagasy ariary','Ar','MGA'),
array('Macedonia, Republic of','Macedonian denar','ден','MKD'),
array('Burma','Burmese kyat','Ks','MMK'),
array('Mongolia','Mongolian tögrög','₮','MNT'),
array('Macau','Macanese pataca','P','MOP'),
array('Mauritania','Mauritanian ouguiya','UM','MRO'),
array('Sahrawi Republic[M]','Mauritanian ouguiya','UM','MRO'),
array('Mauritius','Mauritian rupee','₨','MUR'),
array('Maldives','Maldivian rufiyaa','.ރ','MVR'),
array('Malawi','Malawian kwacha','MK','MWK'),
array('Mexico','Mexican peso','$','MXN'),
array('Malaysia','Malaysian ringgit','RM','MYR'),
array('Mozambique','Mozambican metical','MT','MZN'),
array('Namibia','Namibian dollar','$','NAD'),
array('Nigeria','Nigerian naira','₦','NGN'),
array('Nicaragua','Nicaraguan córdoba','C$','NIO'),
array('Norway','Norwegian krone','kr','NOK'),
array('Nepal','Nepalese rupee','₨','NPR'),
array('Cook Islands','New Zealand dollar','$','NZD'),
array('New Zealand','New Zealand dollar','$','NZD'),
array('Niue','New Zealand dollar','$','NZD'),
array('Pitcairn Islands','New Zealand dollar','$','NZD'),
array('Oman','Omani rial','ر.ع.','OMR'),
array('Panama','Panamanian balboa','B/.','PAB'),
array('Peru','Peruvian nuevo sol','S/.','PEN'),
array('Papua New Guinea','Papua New Guinean kina','K','PGK'),
array('Philippines','Philippine peso','₱','PHP'),
array('Pakistan','Pakistani rupee','₨','PKR'),
array('Poland','Polish złoty','zł','PLN'),
array('Transnistria','Transnistrian ruble','р.','PRB[F]'),
array('Paraguay','Paraguayan guaraní','₲','PYG'),
array('Qatar','Qatari riyal','ر.ق','QAR'),
array('Romania','Romanian leu','lei','RON'),
array('Serbia','Serbian dinar','дин. or din.','RSD'),
array('Abkhazia','Russian ruble','RUB','RUB'),
array('Russia','Russian ruble','RUB','RUB'),
array('South Ossetia','Russian ruble','RUB','RUB'),
array('Ukraine','Russian ruble[P]','RUB','RUB'),
array('Rwanda','Rwandan franc','Fr','RWF'),
array('Saudi Arabia','Saudi riyal','ر.س','SAR'),
array('Solomon Islands','Solomon Islands dollar','$','SBD'),
array('Seychelles','Seychellois rupee','₨','SCR'),
array('Sudan','Sudanese pound','ج.س.','SDG'),
array('Sweden','Swedish krona','kr','SEK'),
array('Brunei','Singapore dollar','$','SGD'),
array('Singapore','Singapore dollar','$','SGD'),
array('United Kingdom Ascension Island','Saint Helena pound','£','SHP'),
array('Saint Helena','Saint Helena pound','£','SHP'),
array('Tristan da Cunha','Saint Helena pound','£','SHP'),
array('Sierra Leone','Sierra Leonean leone','Le','SLL'),
array('Somalia','Somali shilling','Sh','SOS'),
array('Suriname','Surinamese dollar','$','SRD'),
array('South Sudan','South Sudanese pound','£','SSP'),
array('São Tomé and Príncipe','São Tomé and Príncipe dobra','Db','STD'),
array('Syria','Syrian pound','£ or ل.س','SYP'),
array('Swaziland','Swazi lilangeni','L','SZL'),
array('Thailand','Thai baht','฿','THB'),
array('Tajikistan','Tajikistani somoni','ЅМ','TJS'),
array('Turkmenistan','Turkmenistan manat','m','TMT'),
array('Tunisia','Tunisian dinar','د.ت','TND'),
array('Tonga','Tongan paʻanga[O]','T$','TOP'),
array('Northern Cyprus','Turkish lira','TRY','TRY'),
array('Turkey','Turkish lira','TRY','TRY'),
array('Trinidad and Tobago','Trinidad and Tobago dollar','$','TTD'),
array('Taiwan','New Taiwan dollar','$','TWD'),
array('Tanzania','Tanzanian shilling','Sh','TZS'),
array('Ukraine','Ukrainian hryvnia','₴','UAH'),
array('Uganda','Ugandan shilling','Sh','UGX'),
array('Bonaire','United States dollar','$','USD'),
array('British Indian Ocean Territory','United States dollar','$','USD'),
array('British Virgin Islands','United States dollar','$','USD'),
array('Cambodia','United States dollar','$','USD'),
array('East Timor','United States dollar','$','USD'),
array('Ecuador','United States dollar','$','USD'),
array('El Salvador','United States dollar','$','USD'),
array('Marshall Islands','United States dollar','$','USD'),
array('Micronesia','United States dollar','$','USD'),
array('Palau','United States dollar','$','USD'),
array('Panama','United States dollar','$','USD'),
array('Saba','United States dollar','$','USD'),
array('Sint Eustatius','United States dollar','$','USD'),
array('Turks and Caicos Islands','United States dollar','$','USD'),
array('United States','United States dollar','$','USD'),
array('Zimbabwe','United States dollar','$','USD'),
array('Uruguay','Uruguayan peso','$','UYU'),
array('Uzbekistan','Uzbekistani som','UZS','UZS'),
array('Venezuela','Venezuelan bolívar','Bs F','VEF'),
array('Vietnam','Vietnamese đồng','₫','VND'),
array('Vanuatu','Vanuatu vatu','Vt','VUV'),
array('Samoa','Samoan tālā','T','WST'),
array('Cameroon','Central African CFA franc','Fr','XAF'),
array('Central African Republic','Central African CFA franc','Fr','XAF'),
array('Chad','Central African CFA franc','Fr','XAF'),
array('Congo, Republic of the','Central African CFA franc','Fr','XAF'),
array('Equatorial Guinea','Central African CFA franc','Fr','XAF'),
array('Gabon','Central African CFA franc','Fr','XAF'),
array('Anguilla','East Caribbean dollar','$','XCD'),
array('Antigua and Barbuda','East Caribbean dollar','$','XCD'),
array('Dominica','East Caribbean dollar','$','XCD'),
array('Grenada','East Caribbean dollar','$','XCD'),
array('Montserrat','East Caribbean dollar','$','XCD'),
array('Saint Kitts and Nevis','East Caribbean dollar','$','XCD'),
array('Saint Lucia','East Caribbean dollar','$','XCD'),
array('Saint Vincent and the Grenadines','East Caribbean dollar','$','XCD'),
array('Benin','West African CFA franc','Fr','XOF'),
array('Burkina Faso','West African CFA franc','Fr','XOF'),
array('Côte d\'\'Ivoire','West African CFA franc','Fr','XOF'),
array('Guinea-Bissau','West African CFA franc','Fr','XOF'),
array('Mali','West African CFA franc','Fr','XOF'),
array('Niger','West African CFA franc','Fr','XOF'),
array('Senegal','West African CFA franc','Fr','XOF'),
array('Togo','West African CFA franc','Fr','XOF'),
array('French Polynesia','CFP franc','Fr','XPF'),
array('New Caledonia','CFP franc','Fr','XPF'),
array('Wallis and Futuna','CFP franc','Fr','XPF'),
array('Yemen','Yemeni rial','﷼','YER'),
array('Lesotho','South African rand','R','ZAR'),
array('Namibia','South African rand','R','ZAR'),
array('South Africa','South African rand','R','ZAR'),
array('Zimbabwe','South African rand','R','ZAR'),
array('Zambia','Zambian kwacha','ZK','ZMW')
);

$id = 1;
$present = array();

echo "===============================================\n";
echo "=== SQL Version                             ===\n";
echo "===============================================\n";

foreach ($currencies as $currency)
{
	if (!isset($present[$currency[3]]))
	{
		echo 'INSERT INTO "currency" ("_id", "iso_code", "name", "symbol", "country") VALUES (' . $id . ', \'' . $currency[3] . '\', \'' . $currency[1] . '\', \'' . $currency[2] . '\', \'' . $currency[0] . '\');' . "\n";
		$present[$currency[3]] = 'set';

		$id++;
	}
	else
	{
		echo 'UPDATE "currency" SET "country" = "country" || \', ' . $currency[0] . '\' WHERE "iso_code" = \'' . $currency[3] . '\';' . "\n";
	}
}


$id = 1;
$present = array();

echo "\n\n\n";
echo "===============================================\n";
echo "=== Java Version                            ===\n";
echo "===============================================\n";

echo "\tpublic static final String[][] BASE_VALUES = {\n";

foreach ($currencies as $currency)
{
	if (!isset($present[$currency[3]]))
	{
		echo "\t\t" .'{"' . $id . '", "' . $currency[3] . '", "' . $currency[1] . '", "' . $currency[2] . '", "' . $currency[0] . '"},' . "\n";
		$present[$currency[3]] = 'set';

		$id++;
	}
}
echo "};\n";


$id = 1;
unset($present);
$present = array();
echo "\tpublic static final String[] CURRENCY_INSERT_QUERY = {\n";

foreach ($currencies as $currency)
{
	if (!isset($present[$currency[3]]))
	{
		echo "\t\t" .'"INSERT INTO currency (_id, iso_code, name, symbol, country) VALUES (' . $id . ', \'' . $currency[3] . '\', \'' . $currency[1] . '\', \'' . $currency[2] . '\', \'' . $currency[0] . '\');",' . "\n";
		$present[$currency[3]] = 'set';

		$id++;
	}
	else
	{
		echo "\t\t" . '"UPDATE currency SET country = country || \', ' . $currency[0] . '\' WHERE iso_code = \'' . $currency[3] . '\';",' . "\n";
	}
}
echo "};\n";


?>
