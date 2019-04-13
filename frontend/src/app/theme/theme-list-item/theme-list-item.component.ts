import {Component, Input, OnInit} from '@angular/core';
import {ITheme} from '../theme.model';
import {Global} from '../../app.global.service';

@Component({
  selector: 'theme-list-item',
  templateUrl: './theme-list-item.component.html',
  styleUrls: ['./theme-list-item.component.scss']
})
export class ThemeListItemComponent implements OnInit {

  @Input() theme: ITheme;
  width: number;

  constructor() {
    this.width = Global.CARD_WIDTH;
  }

  ngOnInit() {
  }
}
