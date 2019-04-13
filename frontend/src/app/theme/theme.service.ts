import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ITheme, Tag, Theme} from './theme.model';
import {Observable} from 'rxjs/index';

@Injectable()
export class ThemeService {

  themes: ITheme[] = [
    new Theme(1, '이낙연', '야권 대선주자', [new Tag(1, '정치'), new Tag(2, '대선')], this.getDummyRandomData(), 'http://www.sporbiz.co.kr/news/photo/201709/144739_136693_236.png'),
    new Theme(2, '황교안', '여권 대선주자', [new Tag(1, '정치'), new Tag(2, '대선')], this.getDummyRandomData(), 'https://newsimg.sedaily.com/2019/01/16/1VE26EEAPW_1.jpg'),
    new Theme(3, '자율주행', '택시 대체재', [new Tag(3, '4차 산업혁명')], this.getDummyRandomData(), 'http://www.lgblog.co.kr/wp-content/uploads/2016/08/shutterstock_329936327-672x448.jpg'),
    new Theme(4, '5G', '새로운 시대', [new Tag(3, '4차 산업혁명')], this.getDummyRandomData(), 'https://assets.pcmag.com/media/images/633267-5g-generic-art.jpg?thumb=y&width=810&height=456'),
    new Theme(5, '지진', '우리도 안전할 수 없다', [new Tag(4, '자연재해')], this.getDummyRandomData(), 'http://www.palnews.co.kr/news/photo/bbs/old/201609_81994.jpg'),
    new Theme(6, '태풍', '여름 단골 손님', [new Tag(4, '자연재해')], this.getDummyRandomData(), 'https://img.huffingtonpost.com/asset/5b6c353f200000dd02379511.jpeg?ops=scalefit_630_noupscale'),
    new Theme(1, '이낙연', '야권 대선주자', [new Tag(1, '정치'), new Tag(2, '대선')], this.getDummyRandomData(), 'http://www.sporbiz.co.kr/news/photo/201709/144739_136693_236.png'),
    new Theme(2, '황교안', '여권 대선주자', [new Tag(1, '정치'), new Tag(2, '대선')], this.getDummyRandomData(), 'https://newsimg.sedaily.com/2019/01/16/1VE26EEAPW_1.jpg'),
    new Theme(3, '자율주행', '택시 대체재', [new Tag(3, '4차 산업혁명')], this.getDummyRandomData(), 'http://www.lgblog.co.kr/wp-content/uploads/2016/08/shutterstock_329936327-672x448.jpg'),
    new Theme(4, '5G', '새로운 시대', [new Tag(3, '4차 산업혁명')], this.getDummyRandomData(), 'https://assets.pcmag.com/media/images/633267-5g-generic-art.jpg?thumb=y&width=810&height=456'),
    new Theme(5, '지진', '우리도 안전할 수 없다', [new Tag(4, '자연재해')], this.getDummyRandomData(), 'http://www.palnews.co.kr/news/photo/bbs/old/201609_81994.jpg'),
    new Theme(6, '태풍', '여름 단골 손님', [new Tag(4, '자연재해')], this.getDummyRandomData(), 'https://img.huffingtonpost.com/asset/5b6c353f200000dd02379511.jpeg?ops=scalefit_630_noupscale'),
    new Theme(1, '이낙연', '야권 대선주자', [new Tag(1, '정치'), new Tag(2, '대선')], this.getDummyRandomData(), 'http://www.sporbiz.co.kr/news/photo/201709/144739_136693_236.png'),
    new Theme(2, '황교안', '여권 대선주자', [new Tag(1, '정치'), new Tag(2, '대선')], this.getDummyRandomData(), 'https://newsimg.sedaily.com/2019/01/16/1VE26EEAPW_1.jpg'),
    new Theme(3, '자율주행', '택시 대체재', [new Tag(3, '4차 산업혁명')], this.getDummyRandomData(), 'http://www.lgblog.co.kr/wp-content/uploads/2016/08/shutterstock_329936327-672x448.jpg'),
    new Theme(4, '5G', '새로운 시대', [new Tag(3, '4차 산업혁명')], this.getDummyRandomData(), 'https://assets.pcmag.com/media/images/633267-5g-generic-art.jpg?thumb=y&width=810&height=456'),
    new Theme(5, '지진', '우리도 안전할 수 없다', [new Tag(4, '자연재해')], this.getDummyRandomData(), 'http://www.palnews.co.kr/news/photo/bbs/old/201609_81994.jpg'),
    new Theme(6, '태풍', '여름 단골 손님', [new Tag(4, '자연재해')], this.getDummyRandomData(), 'https://img.huffingtonpost.com/asset/5b6c353f200000dd02379511.jpeg?ops=scalefit_630_noupscale'),
  ];

  constructor(
    private http: HttpClient
  ) {

  }

  getThemes(): Observable<ITheme[]> {
    // return this.http.get(``);
    return new Observable(observer => {
      observer.next(this.themes);
      observer.complete();
      return {unsubscribe() {}};
    });
  }

  // TODO 임시코드
  getDummyRandomData(): number[] {
    const result: number[] = [];

    let seed: number = Math.floor(Math.random() * 100000) + 5000;

    while (result.length < 100) {
      seed += Math.floor(Math.random() * seed * 0.06) - seed * 0.03;
      result.push(seed);
    }

    return result;
  }
}
