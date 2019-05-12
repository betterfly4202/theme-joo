# 구문
### GOOGLEFINANCE(시세_표시, [속성], [시작일], [종료일|일수], [간격])

---
 
- 시세_표시 - 고려할 유가증권의 시세 표시입니다.
    - 참고: Reuters Instrument Codes는 더 이상 지원되지 않습니다. 예를 들어 ticker 123.TO 또는 XYZ.AX는 작동하지 않습니다. 대신 TSE:123 또는 ASX:XYZ를 사용하세요.
    - 권장: 불일치를 피하려면 거래소를 추가하세요. 예를 들어 'GOOG' 대신 'NASDAQ:GOOG'를 사용하세요. 거래소가 명시되지 않은 경우 제일 적합한 거래소가 GOOGLEFINANCE에서 자동으로 선택됩니다.

- 속성 - [ 선택사항 - 기본값은 'price' ] - Google Finance에서 시세_표시에 대해 가져올 속성입니다. 날짜가 지정된 경우 필수 항목입니다.
    - 실시간 데이터의 경우 다음 중 하나를 attribute로 사용할 수 있습니다.

        - "price" - 실시간 가격 정보로 최대 20분까지 지연됩니다.
        - "priceopen" - 개장 시점의 가격입니다.
        - "high" - 현재 날짜의 최고가입니다.
        - "low" - 현재 날짜의 최저가입니다.
        - "volume" - 현재 날짜의 거래량입니다.
        - "marketcap" - 주식의 시가 총액입니다.
        - "tradetime" - 마지막 거래 시간입니다.
        - "datadelay" - 실시간 데이터의 지연 정도입니다.
        - "volumeavg" - 일일 평균 거래량입니다.
        - "pe" - 가격 대 수익률입니다.
        - "eps" - 주당 순이익입니다.
        - "high52" - 52주 최고가입니다.
        - "low52" - 52주 최저가입니다.
        - "change" - 전 거래일 마감 이후의 가격 변동입니다.
        - "beta" - 베타 값입니다.
        - "changepct" - 전 거래일 마감 이후 주식 가격의 백분율 변동입니다.
        - "closeyest" - 전일 종가입니다.
        - "shares" - 발행 주식 수입니다.
        - "통화" - 유가증권이 거래되는 통화입니다. 통화에는 거래 기간이 없으므로 개장가, 최저가, 최고가, 거래량은 이 인수에 반환되지 않습니다.

    - 이전 데이터의 경우 다음 중 하나를 속성으로 사용할 수 있습니다.
        - "open" - 지정한 날짜의 개장가입니다.
        - "close" - 지정한 날짜의 종가입니다.
        - "high" - 지정한 날짜의 최고가입니다.
        - "low" - 지정한 날짜의 최저가입니다.
        - "volume" - 지정한 날짜의 거래량입니다.
        - "all" - 위의 모든 속성입니다.
    
    - 뮤추얼 펀드 데이터의 경우 다음 중 하나를 attribute로 사용할 수 있습니다.
        - "closeyest" - 전일 종가입니다.
        - "date" - 순 자산 가치가 보고된 날짜입니다.
        - "returnytd" - YTD(연간) 총 수익입니다.
        - "netassets" - 순 자산입니다.
        - "change" - 가장 최근에 기록한 순 자산 가치와 그 직전에 기록한 순 자산 가치 간의 값 변동입니다.
        - "changepct" - 순 자산 가치의 백분율 변동입니다.
        - "yieldpct" - 지난 12개월 동안 배분된 수입을 모두 합한 금액(주식 배당금과 고정 수입 이자 지급액)에 순 자산 가치 증가분을 더한 다음 전월 순 자산 가치로 나눈 배분율입니다.
        - "returnday" - 1일 총 수익입니다.
        - "return1" - 1주 총 수익입니다.
        - "return4" - 4주 총 수익입니다.
        - "return13" - 13주 총 수익입니다.
        - "return52" - 52주(연간) 총 수익입니다.
        - "return156" - 156주(3년) 총 수익입니다.
        - "return260" - 260주(5년) 총 수익입니다.
        - "incomedividend" - 최근 현금 배분액입니다.
        - "incomedividenddate" - 최근 현금 배분 날짜입니다.
        - "capitalgain" - 최근 자본 이득 배분액입니다.
        - "morningstarrating" - Morningstar의 'star' 등급입니다.
        - "expenseratio" - 펀드의 비용 비율입니다.

- start_date - [ 선택사항 ] - 과거 데이터를 가져올 기간의 시작일입니다.
    - start_date만 지정하고 end_date|num_days를 지정하지 않을 경우 시작일 하루의 데이터만 반환됩니다.

- end_date|num_days - [ 선택사항 ] - 과거 데이터를 가져올 기간의 종료일 또는 데이터를 반환할 start_date로부터의 일수입니다.

- 간격 - [ 선택사항 ] - 데이터 반환 빈도로 'DAILY'(매일) 또는 'WEEKLY'(매주) 중 하나를 선택할 수 있습니다.
    - interval을 1 또는 7로 지정할 수도 있습니다. 다른 숫자 값은 사용할 수 없습니다.