## [구글 finance 구문](https://support.google.com/docs/answer/3093281?hl=ko)


# 크롤링 정보
*크롤링 api* : https://kind.krx.co.kr/corpgeneral/corpList.do

**marketType** 
- stockMkt : 유가증권
- kosdaqMkt : 코스닥
- konexMkt : 코넥스

## form body 예시
~~~json
{
    "marketType" : "stockMkt",
    "method" : "download",
    "pageIndex" : "1",
    "orderMode" : "3",
    "orderStat" : "D",
    "searchType" : "13",
    "fiscalYearEnd" : "all",
    "location" : "all"
}
~~~


