import { TestBed } from '@angular/core/testing';

import { ListeUserGuard } from './liste-user.guard';

describe('ListeUserGuard', () => {
  let guard: ListeUserGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ListeUserGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
